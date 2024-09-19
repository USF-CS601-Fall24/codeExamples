package designPatterns.creatingObjects.staticFactoryMethods;

import java.lang.reflect.InvocationTargetException;

public interface EnemyShip {
    void attack();
    static EnemyShip getInstance(String type) {
        /*
        // This will work, but is not "closed for modification".
        // if we introduce a new type of the ship, we'd have to modify this class by adding ifs
        if (type.endsWith("UFOShip"))
            return new UFOShip();
        else if (type.endsWith("PirateShip"))
                return new PirateShip();
        return null;

         */
        // This version uses reflection
        // Specific ship classes do not even need to exist when we write this code
        // They should exist at runtime.
        try {
            Class cl = Class.forName(type);
            Object obj = cl.getDeclaredConstructor().newInstance();
           // Object obj = cl.getConstructor(String.class).newInstance("Rogue wave"); // would work if the constructor takes a string
            EnemyShip ship = (EnemyShip) obj;
            return ship;

        } catch (ClassNotFoundException | NoSuchMethodException| InstantiationException | IllegalAccessException | InvocationTargetException e) {
            System.out.println(e);
        }
        return null;

       }
}
