package designPatterns.structural.facade;

class SmartHomeFacade {
    private Light light;
    private Thermostat thermostat;
    private SecuritySystem securitySystem;

    public SmartHomeFacade(Light light, Thermostat thermostat, SecuritySystem securitySystem) {
        this.light = light;
        this.thermostat = thermostat;
        this.securitySystem = securitySystem;
    }

    public void arriveHome() {
        System.out.println("Arriving home: ");
        light.turnOn();
        thermostat.setTemperature(72);
        securitySystem.deactivate();
    }

    public void leaveHome() {
        System.out.println("Leaving home:");
        light.turnOff();
        thermostat.setTemperature(60);
        securitySystem.activate();
    }

    public void sleep() {
        System.out.println("Night:");
        light.turnOff();
        thermostat.setTemperature(68);
        securitySystem.activate(); // or whatever makes sense
    }
}
