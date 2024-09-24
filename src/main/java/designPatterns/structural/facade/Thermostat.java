package designPatterns.structural.facade;

class Thermostat {
    private double temperature;

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Thermostat set to " + temperature + " degrees.");
    }

    public void increaseTemperature(double delta) {
        temperature += delta;
        System.out.println("Thermostat temperature increased by " + delta + " degrees.");

    }

    public void decreaseTemperature(double delta) {
        temperature -= delta;
        System.out.println("Thermostat temperature reduced by " + delta + " degrees.");

    }
}
