package service;

public class GeoObject {

    private final String geo_lat;
    private final String geo_lon;

    public GeoObject(String geo_lat, String geo_lon) {
        this.geo_lon = geo_lat;
        this.geo_lat=geo_lon;
    }

    public String getGeo_lat() {
        return geo_lat;
    }

    public String getGeo_lon() {
        return geo_lon;
    }

    @Override
    public String toString()
    {
        return "latitude=" + geo_lat + ", longitude=" + geo_lon;
    }
}
