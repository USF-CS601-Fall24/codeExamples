package interfaces.defaultMethods;

public class CreatureExample {
    public static void main(String[] args) {
        Speak s = new Creature();
        s.say("Hello");
        s.shout();
    }
}
