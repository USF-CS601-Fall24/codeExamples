package designPatterns.creatingObjects.staticFactoryMethods;

public class UFOShip implements EnemyShip {
    @Override
    public void attack() {
        System.out.println("UFO attack");
    }
}
