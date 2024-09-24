package designPatterns.structural.facade;

class Light {
    private boolean onOffSwitch = false;

    public void turnOn() {
        onOffSwitch = true;
        System.out.println("Lights are turned ON.");
    }

    public void turnOff() {
        onOffSwitch = false;
        System.out.println("Lights are turned OFF.");
    }
}
