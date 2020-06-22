package javaSE.serialisation;

public class Weather {
    private double lon;
    private double lat;
    private String city_name;
    private int temperature;
    private int humidity;

    public Weather(){}

    public Weather(double lon, double lat, String city_name, int temperature, int humadity) {
        this.lon = lon;
        this.lat = lat;
        this.city_name = city_name;
        this.temperature = temperature;
        this.humidity = humadity;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
}
