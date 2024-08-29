package interfaces.comparator.studentExample;

public class Student  {
    public static final double GPA_THRES = 0.01;
    private String name;
    private int id;
    private double averageGPA;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Student(String name, int id, double averageGPA) {
        this.name = name;
        this.id = id;
        this.averageGPA = averageGPA;
    }

    public void setId(int newId) {
        this.id = newId;
    }

    public void setName(String name) {this.name = name; }

    @Override
    public String toString() {
        return name + ": " + id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
