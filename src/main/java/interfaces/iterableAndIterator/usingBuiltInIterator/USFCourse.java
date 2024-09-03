package interfaces.iterableAndIterator.usingBuiltInIterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/* Represents a course at a univesity */
public class USFCourse  implements Iterable<Student> {
    private List<Student> students; // stores students in an ArrayList
    private String courseID;

    public USFCourse(String courseID) {
        this.courseID = courseID;
        this.students = new ArrayList<>();
    }

    public void addStudent(String name, int studentId) {
        Student st = new Student(name, studentId);
        students.add(st);
    }


    @Override
    public Iterator<Student> iterator() {
        return students.iterator();
    }


}