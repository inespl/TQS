public class Address {
    private String road;
    private String city;
    private String state;
    private String zip;
    private String houseNumber;

    public Address(String road, String city, String state, String zip, String houseNumber){
        this.city=city;
        this.road=road;
        this.houseNumber=houseNumber;
        this.zip=zip;
        this.state=state;
    }

    public String toString(){
        return String.format("%s, %s, %s, %s, %s", this.road, this.houseNumber, this.zip, this.city, this.state);
    }


    public String getRoad() {
        return road;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getHouseNumber() {
        return houseNumber;
    }
}
