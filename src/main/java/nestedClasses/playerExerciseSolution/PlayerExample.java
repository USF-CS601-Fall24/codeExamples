package nestedClasses.playerExerciseSolution;


import java.util.SortedSet;
import java.util.TreeSet;

public class PlayerExample {
    public static void main(String[] args) {
        Player p1 = new Player("A", 0.367);
        Player p2 = new Player("B", 0.312);
        Player p3 = new Player("C", 0.389);

        // Pass an instance of an anonymous class that implements Comparator
        // and compares players by batting average (scores within eps = 0.01 are considered equal).
        SortedSet<Player> players1 = new TreeSet<>((o1, o2) -> {
            double thres = 0.01;
            if (Math.abs(o1.getBattingAverage() - o2.getBattingAverage()) < thres) {
                return 0;
            }
            else
                return Double.compare(o1.getBattingAverage(), o2.getBattingAverage());
        });
        players1.add(p1);
        players1.add(p2);
        players1.add(p3);
        System.out.println(players1);
       
        // Pass an instance of an anonymous class that implements Comparator
        // and compares players by name
        // Use lambda
        SortedSet<Player> players2 = new TreeSet<>((o1, o2) -> o1.getName().compareTo(o2.getName()));
        players2.add(p1);
        players2.add(p2);
        players2.add(p3);
        System.out.println(players2);
    }
}
