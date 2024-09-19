package designPatterns.creatingObjects.staticFactoryMethods;

import java.lang.reflect.Field;

public class ReflectionExample {
    // Not related to static factory methods
    public static void main(String[] args) {
        try {
            PirateShip p = new PirateShip("Sparrow");
            Field privateField = PirateShip.class.getDeclaredField("name");
            privateField.setAccessible(true);
            String name = (String)privateField.get(p);
            System.out.println(name);
        }
        catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println(e);
        }
    }
}
