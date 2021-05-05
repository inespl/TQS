package tqs.controller;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import tqs.entities.Quality;

import java.util.Arrays;

public class RestClient {

    public static final String AIR_QUALITY_DATA = "https://api.weatherbit.io/v2.0/current/airquality?";
    public static final String KEY = "&key=bb5a83eef6fb4c56a9beca95d5362b9e";
    static RestTemplate restTemplate = new RestTemplate();


    public static void main(String[] args) {
        double lat = Double.parseDouble(args[0]);
        double lon = Double.parseDouble(args[1]);
        callGetAirQualityInLocation(lat, lon);
    }

    // https://api.weatherbit.io/v2.0/current/airquality?lat=40.6442700&lon=-8.6455400&key=bb5a83eef6fb4c56a9beca95d5362b9e
    private static void callGetAirQualityInLocation(double lat, double lon){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        String url = AIR_QUALITY_DATA + "lat=" + lat + "&lon=" + lon + KEY;
        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println(result);
        //<200,{"data":[{"mold_level":1,"aqi":17,"pm10":18,"co":227,"o3":11,"predominant_pollen_type":"Molds","so2":1.38208,"pollen_level_tree":1,"pollen_level_weed":1,"no2":14,"pm25":1,"pollen_level_grass":1}],"city_name":"Aveiro","lon":-8.65,"timezone":"Europe\/Lisbon","lat":40.64,"country_code":"PT","state_code":"02"}

    }
    // passar a retornar Quality

}
