package jsonProcessing.hotelParsingExerciseSolution;

import com.google.gson.annotations.SerializedName;

/** A class that represents a hotel. */
public class Hotel {
    @SerializedName(value = "f")
    private String name;
    private String id;

    @SerializedName(value="ad")
    private String streetAddress;
    @SerializedName(value="ci")
    private String city;

    private double lat;
    private double lon;

    public Hotel(String name, String id, String streetAddress, String city, double lat, double lon) {
        this.name = name;
        this.id = id;
        this.streetAddress = streetAddress;
        this.city = city;
        this.lat = lat;
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "Hotel: " +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", lat=" + lat +
                ", lon=" + lon;
    }
}
