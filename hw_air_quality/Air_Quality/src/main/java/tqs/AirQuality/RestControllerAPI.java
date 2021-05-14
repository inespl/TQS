package tqs.AirQuality;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class RestControllerAPI {
    WebController wc = new WebController();
    int ttl = 120000;
    Cache cache = new Cache(ttl); // 2 min
    Gson gson = new Gson();
    int hits = 0;
    int misses = 0;

    public RestControllerAPI() throws IOException {
    }

    @GetMapping("/api")
    public String apiDataLatLon(@RequestParam(name = "lat") double lat, @RequestParam(name = "lon") double lon) {
        String latlon = lat + "," + lon;
        String quality_json = cache.get(latlon);

        if (quality_json == null){
            misses ++;
            quality_json = wc.callGetAirQualityByLatLon(lat, lon);
            cache.put(latlon, quality_json);
        }else
            hits ++;

        return quality_json;
    }

    @GetMapping("/api/statistics")
    public String apiDataStats() {
        HashMap<String, Integer> data = new HashMap<>();
        data.put("requests", hits+misses);
        data.put("hits", hits);
        data.put("misses", misses);
        data.put("ttl", ttl);

        return gson.toJson(data);
    }

    @GetMapping("/api/cache")
    public String apiDataCache() {
        HashMap<String, List<HashMap<String, Double>>> data = new HashMap<>();
        List<HashMap<String, Double>> listOfLocations = new ArrayList<>();
        HashMap<String, Double> latLons;
        List<String> keys = cache.getCache();
        for(String key: keys){
            latLons = new HashMap<>();
            String[] latLon = key.split(",");
            latLons.put("lon", Double.parseDouble(latLon[1]));
            latLons.put("lat", Double.parseDouble(latLon[0]));
            listOfLocations.add(latLons);
        }
        data.put("data", listOfLocations);

        return gson.toJson(data);
    }

}
