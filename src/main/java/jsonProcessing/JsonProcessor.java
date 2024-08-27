package jsonProcessing;

import com.google.gson.*;

import java.io.FileReader;
import java.io.IOException;

/** The example demonstrates reading from a JSON file */
public class JsonProcessor {
    public static void main(String[] args) {
        JsonProcessor jp = new JsonProcessor();
        jp.parseFruitFile("input/fruit.json");
        //jp.parsePersonInfo("input/personInfo.json");
        //jp.parseJson("input/personInfo.json", Person.class);
        //jp.writePersonInfoToJson();
        //jp.parsePeopleArray("input/people.json");
    }

    /**
     * This method demonstrates how to parse a simple json file
     * that contains info about fruits; using GSON library.
     * Look at fruit.json and class Fruit.
     *
     * @param filePath path to the json file
     */
    public void parseFruitFile(String filePath) {
        Gson gson = new Gson();
        System.out.println("Created the following object from fruit.json :");
        System.out.println();

        try (FileReader fr = new FileReader(filePath)) {
            Fruit fruit = gson.fromJson(fr, Fruit.class);
            System.out.println(fruit);
        } catch (IOException e) {
            System.out.println("Could not read the file:" + e);
        }
    }


    /**
     * This method demonstrates how to parse a json file
     * that contains info about a person using GSON library.
     * Person has an address that is also a Json object.
     * See personInfo.json and classes Person and Address.
     *
     * @param filePath path to the json file
     */
    public void parsePersonInfo(String filePath) {
        Gson gson = new Gson();
        try (FileReader fr = new FileReader(filePath)) {
            // Parse the json file into a Person object
            Person p = gson.fromJson(fr, Person.class);
            System.out.println("Created the following object from personInfo.json file:");
            System.out.println();
            System.out.println(p);

        } catch (IOException e) {
            System.out.println("Could not read the file: " + e);
        }
    }

    /**
     * A more general method that can be used to convert a json file to the object of a given class/type.
     * @param filename filename
     * @param objectType class of an object to read from file
     */
    public void parseJson(String filename, Class objectType) {
        Gson gson = new Gson();
        try (FileReader fr = new FileReader(filename)) {
            Object p = gson.fromJson(fr, objectType);
            System.out.println("Created the following object from json file:");
            System.out.println();
            System.out.println(p);
        } catch (IOException e) {
            System.out.println("Could not read the file: " + e);
        }
    }

    /**
     * Demonstrates how to convert an object to a  json string
     * @return json string representing the object
     */
    public String writePersonInfoToJson() {
        Address address = new Address("CA", "San Francisco", "Geary", 45);
        Person person = new Person("Joe Lee", 1, "Tester", address);
        // Save an object p of class Person to a json file:
        Gson gson;
        //gson = new Gson();
        // Or better use this syntax - see what it does differently:
        gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonInString  = gson.toJson(person);
        System.out.println();
        System.out.println("Json string: ");
        System.out.println(jsonInString);
        return jsonInString;
    }

    /**
     * This method demonstrates how to parse a json file
     * that contains info about several people (value stored in a JSON Array).
     * Uses GSON library.
     *
     * @param filePath path to the json file
     */
    public void parsePeopleArray(String filePath) {
        Gson gson = new Gson();

        try (FileReader fr = new FileReader(filePath)) {
            JsonParser parser = new JsonParser();
            JsonObject jo = (JsonObject) parser.parse(fr);
            JsonArray jsonArr = jo.getAsJsonArray("people");

            // The commented code is if we want to use an ArrayList instead of array of Person-s
            //Type peopleType = new TypeToken<ArrayList<Person>>(){}.getType();
            //ArrayList<Person> people = gson.fromJson(jsonArr, peopleType);
            Person[] people = gson.fromJson(jsonArr, Person[].class);
            for (Person p : people) {
                System.out.println(p);
                System.out.println();
            }

            // Another  way of reading from json to a class would be:
            //People people = gson.fromJson(fr, People.class); // but why would I create class People? Can do without it.
            //System.out.println(people);

        } catch (IOException e) {
            System.out.println("Could not read the file: " + e);
        }
    }

}
