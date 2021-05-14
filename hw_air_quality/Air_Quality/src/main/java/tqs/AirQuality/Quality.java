package tqs.AirQuality;

import org.json.JSONArray;
import org.json.JSONObject;

public class Quality {
    public double lat;
    public double lon;
    public String cityName;
    public String timezone;
    public String countryCode;
    public String stateCode;
    public int aqi;
    public double o3;
    public double so2;
    public double no2;
    public double co;
    public double  pm10;
    public double pm25;
    public int pollenLevelTree;
    public int pollenLevelGrass;
    public int pollenLevelWeed;
    public int moldLevel;
    public String predominantPollenType;

    public Quality(String json){
        JSONObject root = new JSONObject(json);
        JSONArray data = root.getJSONArray("data");

        JSONObject jsonData = data.getJSONObject(0);
        this.moldLevel = jsonData.getInt("mold_level");
        this.aqi = jsonData.getInt("aqi");
        this.pm10 = jsonData.getInt("pm10");
        this.co = jsonData.getDouble("co");
        this.o3 = jsonData.getDouble("o3");
        this.predominantPollenType = jsonData.getString("predominant_pollen_type");
        this.so2 = jsonData.getDouble("so2");
        this.pollenLevelTree = jsonData.getInt("pollen_level_tree");
        this.pollenLevelWeed =jsonData.getInt("pollen_level_weed");
        this.no2 = jsonData.getDouble("no2");
        this.pm25 = jsonData.getDouble("pm25");
        this.pollenLevelGrass = jsonData.getInt("pollen_level_grass");

        this.cityName = root.getString("city_name");
        this.lon = root.getDouble("lon");
        this.timezone = root.getString("timezone");
        this.lat = root.getDouble("lat");
        this.countryCode = root.getString("country_code");
        this.stateCode = root.getString("state_code");
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("aqi: " + this.aqi + ", ");
        sb.append("so2: " + this.so2 + ", ");
        sb.append("no2: " + this.no2 + ", ");
        sb.append("co: " + this.co + ", ");
        sb.append("o3: " + this.o3 + ", ");
        sb.append("pollen_level_grass: " + this.pollenLevelGrass + ", ");
        sb.append("pollen_level_tree: " + this.pollenLevelTree + ", ");
        sb.append("pollen_level_weed: " + this.pollenLevelWeed + ", ");
        sb.append("mold_level: " + this.moldLevel + ", ");
        sb.append("predominant_pollen_type: " + this.predominantPollenType + ", ");
        sb.append("pm10: " + this.pm10 + ", ");
        sb.append("pm25: " + this.pm25 + ", ");
        sb.append("city_name: " + this.cityName + ", ");
        sb.append("lat: " + this.lat + ", ");
        sb.append("lon: " + this.lon + ", ");
        sb.append("state_code: " + this.stateCode + ", ");
        sb.append("country_code: " + this.countryCode + ", ");
        sb.append("timezone: " + this.timezone + ", ");

        return sb.toString();
    }
}
