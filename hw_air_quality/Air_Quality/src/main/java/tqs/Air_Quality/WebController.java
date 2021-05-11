package tqs.Air_Quality;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;

@Controller
public class WebController {

    public static final String AIR_QUALITY_DATA = "https://api.weatherbit.io/v2.0/current/airquality?";
    public static final String KEY = "&key=bb5a83eef6fb4c56a9beca95d5362b9e";
    static RestTemplate restTemplate = new RestTemplate();
    Cache cache = new Cache(2000);

    // https://api.weatherbit.io/v2.0/current/airquality?lat=40.6442700&lon=-8.6455400&key=bb5a83eef6fb4c56a9beca95d5362b9e
    public static String callGetAirQualityInLocation(double lat, double lon){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        String url = AIR_QUALITY_DATA + "lat=" + lat + "&lon=" + lon + KEY;
        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println(result.getBody());

        String r = result.getBody();

        return r;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("showDetails", false);
        return "homePage";
    }

    @PostMapping("/")
    public String home1(@RequestParam(name = "lat") double lat, @RequestParam(name = "lon") double lon, Model model) {
        Quality quality;
        String latlon = lat + "," + lon;
        String quality_json = cache.get(latlon);

        if (quality_json == null){
            System.out.println("MISS");
            quality_json = callGetAirQualityInLocation(lat, lon);
            cache.put(latlon, quality_json);
        }else{
            System.out.println("HIT");
        }
        quality = new Quality(quality_json);
        System.out.println(quality.getCity_name());

        model.addAttribute("showDetails", true);
        model.addAttribute("quality", quality);

        System.out.println("\n--------------------------\n HITS" + cache.getHits() + "\n--------------------------\n Misses" + cache.getMisses() + "\n--------------------------\n");
        return "homePage";
    }
}
