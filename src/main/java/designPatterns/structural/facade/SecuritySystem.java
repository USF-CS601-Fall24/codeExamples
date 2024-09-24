package designPatterns.structural.facade;

public class SecuritySystem {
    public boolean status = false;

    public void activate() {
        System.out.println("Security system activated.");
        status = true;
    }

    public void deactivate() {
        System.out.println("Security system deactivated.");
        status = false;
    }
}
