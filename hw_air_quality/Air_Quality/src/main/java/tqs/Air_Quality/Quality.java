package tqs.Air_Quality;

import org.json.JSONArray;
import org.json.JSONObject;

public class Quality {
    public double lat;
    public double lon;
    public String city_name;
    public String timezone;
    public String country_code;
    public String state_code;
    public int aqi;
    public double o3;
    public double so2;
    public double no2;
    public double co;
    public double  pm10;
    public double pm25;
    public int pollen_level_tree;
    public int pollen_level_grass;
    public int pollen_level_weed;
    public int mold_level;
    public String predominant_pollen_type;

    public Quality(String json){
        JSONObject root = new JSONObject(json);
        JSONArray data = root.getJSONArray("data");

        JSONObject jsonData = data.getJSONObject(0);
        this.mold_level = jsonData.getInt("mold_level");
        this.aqi = jsonData.getInt("aqi");
        this.pm10 = jsonData.getInt("pm10");
        this.co = jsonData.getInt("co");
        this.o3 = jsonData.getDouble("o3");
        this.predominant_pollen_type = jsonData.getString("predominant_pollen_type");
        this.so2 = jsonData.getDouble("so2");
        this.pollen_level_tree = jsonData.getInt("pollen_level_tree");
        this.pollen_level_weed =jsonData.getInt("pollen_level_weed");
        this.no2 = jsonData.getDouble("no2");
        this.pm25 = jsonData.getInt("pm25");
        this.pollen_level_grass = jsonData.getInt("pollen_level_grass");

        this.city_name = root.getString("city_name");
        this.lon = root.getDouble("lon");
        this.timezone = root.getString("timezone");
        this.lat = root.getDouble("lat");
        this.country_code = root.getString("country_code");
        this.state_code = root.getString("state_code");
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("aqi: " + this.aqi + ", ");
        sb.append("so2: " + this.so2 + ", ");
        sb.append("no2: " + this.no2 + ", ");
        sb.append("co: " + this.co + ", ");
        sb.append("o3: " + this.o3 + ", ");
        sb.append("pollen_level_grass: " + this.pollen_level_grass + ", ");
        sb.append("pollen_level_tree: " + this.pollen_level_tree + ", ");
        sb.append("pollen_level_weed: " + this.pollen_level_weed + ", ");
        sb.append("mold_level: " + this.mold_level + ", ");
        sb.append("predominant_pollen_type: " + this.predominant_pollen_type + ", ");
        sb.append("pm10: " + this.pm10 + ", ");
        sb.append("pm25: " + this.pm25 + ", ");
        sb.append("city_name: " + this.city_name + ", ");
        sb.append("lat: " + this.lat + ", ");
        sb.append("lon: " + this.lon + ", ");
        sb.append("state_code: " + this.state_code + ", ");
        sb.append("country_code: " + this.country_code + ", ");
        sb.append("timezone: " + this.timezone + ", ");

        return sb.toString();
    }
}
