package interfaces.polymorphism;

public final class Philosopher implements Speaker {

    @Override
    public void speak() {
        System.out.println("Everybody is a genius. " +
                "But if you judge a fish by its ability to climb a tree, " +
                "it will live its whole life believing that it is stupid.");
        pontificate();
    }

    public void pontificate() {
        System.out.println("Healthy diet must include only raw vegetables.");
    }
}
