package interfaces.defaultMethods;

/** The class has no definition of the shout() method, but it's ok since there is a default implementation in the interface. */
public class Creature implements Speak {
    @Override
    public void say(String greeting) {
        System.out.println(greeting);
    }

   /* @Override
    public void shout() {
        System.out.println("Yell!!!");
    }
    */


    @Override
    public String toString() {
        return "ok";
    }
 
}
 
