package tqs.Air_Quality;

import org.json.JSONArray;
import org.json.JSONObject;

public class Quality {
    private double lat;
    private double lon;
    private String city_name;
    private String timezone;
    private String country_code;
    private String state_code;
    private int aqi;
    private double o3;
    private double so2;
    private double no2;
    private double co;
    private double  pm10;
    private double pm25;
    private int pollen_level_tree;
    private int pollen_level_grass;
    private int pollen_level_weed;
    private int mold_level;
    private String predominant_pollen_type;

    public Quality(String json){
        JSONObject root = new JSONObject(json);
        JSONArray data = root.getJSONArray("data");

        JSONObject jsonData = data.getJSONObject(0);
        this.setMold_level(jsonData.getInt("mold_level"));
        this.setAqi(jsonData.getInt("aqi"));
        this.setPm10(jsonData.getInt("pm10"));
        this.setCo(jsonData.getInt("co"));
        this.setO3(jsonData.getDouble("o3"));
        this.setPredominant_pollen_type(jsonData.getString("predominant_pollen_type"));
        this.setSo2(jsonData.getDouble("so2"));
        this.setPollen_level_tree(jsonData.getInt("pollen_level_tree"));
        this.setPollen_level_weed(jsonData.getInt("pollen_level_weed"));
        this.setNo2(jsonData.getDouble("no2"));
        this.setPm25(jsonData.getInt("pm25"));
        this.setPollen_level_grass(jsonData.getInt("pollen_level_grass"));

        this.setCity_name(root.getString("city_name"));
        this.setLon(root.getDouble("lon"));
        this.setTimezone(root.getString("timezone"));
        this.setLat(root.getDouble("lat"));
        this.setCountry_code(root.getString("country_code"));
        this.setState_code(root.getString("state_code"));
    }

    /*public boolean compare(Quality q){
        if(this.aqi==q.aqi && this.co==q.co && this.city_name.equals(q.city_name) && this.country_code.equals(q.country_code)
                && this.lat == q.lat && this.lon == q.lon && this.mold_level == q.mold_level && this.no2 == q.no2 && this.o3 == q.o3
                && this.pm10 == q.pm10 && this.pm25 == q.pm25 && this.pollen_level_grass == q.pollen_level_grass
                && this.pollen_level_tree == q.pollen_level_tree && this.pollen_level_weed == q.pollen_level_weed
                && this.predominant_pollen_type.equals(q.predominant_pollen_type) && this.state_code.equals(q.state_code)
                && this.timezone.equals(q.timezone) ){
            System.out.println("TRUE");
            return true;
        }
        return false;
    }*/

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getState_code() {
        return state_code;
    }

    public void setState_code(String state_code) {
        this.state_code = state_code;
    }

    public int getAqi() {
        return aqi;
    }

    public void setAqi(int aqi) {
        this.aqi = aqi;
    }

    public double getO3() {
        return o3;
    }

    public void setO3(double o3) {
        this.o3 = o3;
    }

    public double getSo2() {
        return so2;
    }

    public void setSo2(double so2) {
        this.so2 = so2;
    }

    public double getNo2() {
        return no2;
    }

    public void setNo2(double no2) {
        this.no2 = no2;
    }

    public double getCo() {
        return co;
    }

    public void setCo(double co) {
        this.co = co;
    }

    public double getPm10() {
        return pm10;
    }

    public void setPm10(double pm10) {
        this.pm10 = pm10;
    }

    public double getPm25() {
        return pm25;
    }

    public void setPm25(double pm25) {
        this.pm25 = pm25;
    }

    public int getPollen_level_tree() {
        return pollen_level_tree;
    }

    public void setPollen_level_tree(int pollen_level_tree) {
        this.pollen_level_tree = pollen_level_tree;
    }

    public int getPollen_level_grass() {
        return pollen_level_grass;
    }

    public void setPollen_level_grass(int pollen_level_grass) {
        this.pollen_level_grass = pollen_level_grass;
    }

    public int getPollen_level_weed() {
        return pollen_level_weed;
    }

    public void setPollen_level_weed(int pollen_level_weed) {
        this.pollen_level_weed = pollen_level_weed;
    }

    public int getMold_level() {
        return mold_level;
    }

    public void setMold_level(int mold_level) {
        this.mold_level = mold_level;
    }

    public String getPredominant_pollen_type() {
        return predominant_pollen_type;
    }

    public void setPredominant_pollen_type(String predominant_pollen_type) {
        this.predominant_pollen_type = predominant_pollen_type;
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
