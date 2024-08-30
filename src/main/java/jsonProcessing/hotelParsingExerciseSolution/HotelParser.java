package jsonProcessing.hotelParsingExerciseSolution;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;

public class HotelParser {
    public static void main(String[] args) {
        HotelParser parser = new HotelParser();
        System.out.println(parser.parseHotelJson("src/main/java/jsonProcessing/hotelParsingExerciseSolution/hotel.json"));
    }

    public Hotel parseHotelJson(String filename) {
        try(FileReader fr = new FileReader(filename)) {
           /* Gson gson = new Gson();
            Hotel h = gson.fromJson(fr, Hotel.class);
            return h;
            */
            JsonParser parser = new JsonParser();
            JsonObject ob = (JsonObject)parser.parse(fr);
            String name = ob.get("f").getAsString();
            String id = ob.get("id").getAsString();
            String ad = ob.get("ad").getAsString();
            String city = ob.get("ci").getAsString();
            JsonObject ll = ob.getAsJsonObject("ll");
            double lat = ll.get("lat").getAsDouble();
            double lon = ll.get("lng").getAsDouble();
            return new Hotel(name, id, ad, city, lat, lon);


        }
        catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }

}
