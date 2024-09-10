package inheritance.usfDatabase;

public class USFStudent extends USFPerson {
    private double currentGPA;
    // there could be other instance variables like transcript

    public USFStudent(String name, String id, double gpa) {
        super(name, id);
        this.currentGPA = gpa;
    }

    public double getGpa() {
        return currentGPA;
    }

    @Override
    protected void print() {
        super.print();
        System.out.println("GPA = " + currentGPA);
    }

    // other methods
}
