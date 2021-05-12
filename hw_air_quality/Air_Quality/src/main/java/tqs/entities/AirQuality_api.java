package tqs.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AirQuality_api {

    private Long id;
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

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

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
}
