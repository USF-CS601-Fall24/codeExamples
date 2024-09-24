package designPatterns.structural.facade;

public class SmartHomeDriver {
    public static void main(String[] args) {
        Light light = new Light();
        Thermostat thermostat = new Thermostat();
        SecuritySystem securitySystem = new SecuritySystem();

        SmartHomeFacade homeManager = new SmartHomeFacade(light, thermostat, securitySystem);
        homeManager.arriveHome();
        System.out.println();
        homeManager.leaveHome();
    }
}
