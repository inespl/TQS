package tqs.Air_Quality;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class Rest_Controller {
    WebController wc = new WebController();
    Cache cache = new Cache(120000); // 2 min
    Gson gson = new Gson();
    int hits = 0;
    int misses = 0;

    @GetMapping("/api")
    public String apiData_latlon(@RequestParam(name = "lat") double lat, @RequestParam(name = "lon") double lon) {
        String latlon = lat + "," + lon;
        String quality_json = cache.get(latlon);

        if (quality_json == null){
            misses ++;
            quality_json = wc.callGetAirQualityInLocation(lat, lon);
            cache.put(latlon, quality_json);
        }else
            hits ++;

        return quality_json;
    }

    @GetMapping("/api/statistics")
    public String apiData_stats() {
        HashMap<String, Integer> data = new HashMap<>();
        data.put("requests", hits+misses);
        data.put("hits", hits);
        data.put("misses", misses);

        return gson.toJson(data);
    }
}
