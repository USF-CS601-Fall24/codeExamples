package inheritance.usfDatabase;

import java.util.ArrayList;
import java.util.List;

public class USFFaculty extends USFEmployee {
    private List<String> courses;

    public USFFaculty(String name, String id, int num) {
        super(name, id, num);
        courses = new ArrayList<>();
    }

    public void addCourse(String course) {
        courses.add(course);
    }

    @Override
    protected void print() {
        super.print();
        System.out.println("Courses: " + courses);
    }
}
