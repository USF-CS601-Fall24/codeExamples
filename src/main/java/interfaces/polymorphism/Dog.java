package interfaces.polymorphism;

public  final class Dog implements Speaker {
    @Override
    public void speak() {
        System.out.println("Woof");
    }
}
