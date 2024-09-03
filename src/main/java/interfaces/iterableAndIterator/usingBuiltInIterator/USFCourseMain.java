package interfaces.iterableAndIterator.usingBuiltInIterator;

import java.util.Iterator;

public class USFCourseMain {
    public static void main(String[] args) {
        USFCourse course = new USFCourse("CS601");
        course.addStudent("Katherine Chen", 0);
        course.addStudent("Andrew O'Brien", 1);
        course.addStudent("Priya Ram", 2);
        course.addStudent("Amir Hosseini", 3);

        // Can iterate using an explicit iterator regardless of whether USFCourse implements Iterable
        Iterator<Student> it = course.iterator(); // iterator() method returns an iterator implemented in the ArrayList
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // If USFCourse implements Iterable, we can also use a foreach loop:
        // Uses an iterator behind the curtains
        for (Student st: course) {
            System.out.println(st);
        }
        System.out.println();


    }
}

