package interfaces.comparator.studentExample;

import java.util.*;

public class StudentTestWithComparator {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Student st1 = new Student("C", 1, 3.5671);
        Student st2 = new Student("A", 2, 3.5618);
        Student st3 = new Student("B", 3, 3.1);
        students.add(st1);
        students.add(st2);
        students.add(st3);

        Comparator<Student> comparatorById = new StudentIDComparator();
        Collections.sort(students, comparatorById); // uses a comparator by id for sortingSystem.out.println("After sorting the list by id");
        System.out.println("After sorting the list by id: ");
        System.out.println(students);

        Comparator<Student> comparatorByName = new StudentNameComparator();
        Collections.sort(students, comparatorByName); // uses a comparator by name for sorting
        System.out.println("After sorting the list by name: ");
        System.out.println(students);

        // TreeSet uses a comparator to sort elements
        Set<Student> set1 = new TreeSet<>(comparatorById);
        set1.add(st1);
        set1.add(st2);
        set1.add(st3);
        System.out.println("Show Treeset 1 which uses the comparator by id");
        System.out.println(set1);

        // TreeSet does not get updated when the object changes!
        st1.setId(4);
        System.out.println("TreeSet1 did not rearrange elements when the id of student 1 changed to 4: ");
        System.out.println(set1);
        // TreeSet would not even be able to find this element anymore since the "key" changed
        // Keys of the map/set should not change!

        Set<Student> set2 = new TreeSet<>(comparatorByName);
        set2.add(st1);
        set2.add(st2);
        set2.add(st3);
        System.out.println("Show Treeset 2 which uses the comparator by name");
        System.out.println(set2);
        System.out.println("If we want to change the student's name and rearrange students, we would need to remove the student from the set, change name, and add the changed student to the TreeSet again:");
        set2.remove(st2);
        st2.setName("D");
        set2.add(st2);
        System.out.println(set2);
    }
}
