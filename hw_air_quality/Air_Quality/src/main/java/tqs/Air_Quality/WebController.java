package tqs.Air_Quality;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.LocalTime;

@Controller
public class WebController{

    public static final String AIR_QUALITY_DATA = "https://api.weatherbit.io/v2.0/current/airquality?";
    public static final String KEY = "&key=bb5a83eef6fb4c56a9beca95d5362b9e";
    static RestTemplate restTemplate = new RestTemplate();

    File f;
    FileWriter fw;
    BufferedWriter bf;

    String[] localDateTime = LocalDateTime.now().toString().split("T");
    String[] date = localDateTime[0].split("-");
    String[] time = localDateTime[1].split(":");

    String filename = String.format("logs/access_log_%s%s%s_T_%s%s.txt", date[0], date[1], date[2], time[0], time[1]);

    Cache cache = new Cache(60000); // 1 min
    int hits = 0;
    int misses = 0;

    public WebController() throws IOException {
        f = new File(filename);
        fw = new FileWriter(f);
        bf = new BufferedWriter(fw);
        bf.write(String.format("%s %s \t INFO \t Start of AirQualityApplication%n", localDateTime[0], localDateTime[1]));
        bf.flush();
    }

    // https://api.weatherbit.io/v2.0/current/airquality?lat=40.6442700&lon=-8.6455400&key=bb5a83eef6fb4c56a9beca95d5362b9e
    public String callGetAirQualityInLocation(double lat, double lon){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        String url = AIR_QUALITY_DATA + "lat=" + lat + "&lon=" + lon + KEY;
        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return result.getBody();
    }

    @GetMapping("/")
    public String home(Model model) throws IOException {
        bf = new BufferedWriter(fw);
        model.addAttribute("showDetails", false);
        bf.write(String.format("%s %s \t INFO \t Acessed '/'%n", localDateTime[0], localDateTime[1]));
        bf.flush();
        return "homePage";
    }

    @PostMapping("/")
    public String home1(@RequestParam(name = "lat") double lat, @RequestParam(name = "lon") double lon, Model model) throws IOException {
        bf = new BufferedWriter(fw);
        bf.write(String.format("%s %s \t INFO \t Request for Air Quality of Lat: %f, Lon: %f%n", localDateTime[0], localDateTime[1], lat, lon));
        bf.flush();
        Quality quality;
        String latlon = lat + "," + lon;
        String quality_json = cache.get(latlon);

        cache.getCacheMap();
        if (quality_json == null){
            misses ++;
            quality_json = callGetAirQualityInLocation(lat, lon);
            cache.put(latlon, quality_json);
            bf.write(String.format("%s %s \t INFO \t Request Accepted, API returned the result (not found in cache)%n", localDateTime[0], localDateTime[1]));
            bf.flush();
        }else {
            hits++;
            bf.write(String.format("%s %s \t INFO \t Request Accepted and found in cache%n", localDateTime[0], localDateTime[1]));
            bf.flush();
        }
        quality = new Quality(quality_json);

        model.addAttribute("showDetails", true);
        model.addAttribute("quality", quality);

        return "homePage";
    }
}
