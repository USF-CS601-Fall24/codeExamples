package designPatterns.creatingObjects.staticFactoryMethods;

public class PirateShip implements EnemyShip{
    private String name;

    public PirateShip() {
        System.out.println("Default pirate ship");
    }
    public PirateShip(String name) {
        this.name = name;
    }

    @Override
    public void attack() {
        System.out.println("Pirate ship attack");
    }
}
