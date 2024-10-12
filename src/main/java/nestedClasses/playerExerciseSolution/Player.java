package nestedClasses.playerExerciseSolution;

public class Player {
    private String name; // name of the player
    private double battingAverage; // player's score

    public Player(String name, double bAverage) {
        this.name = name;
        this.battingAverage = bAverage;
    }

    public double getBattingAverage() {
        return this.battingAverage;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return name + ", " + battingAverage;
    }
}