package inheritance.usfDatabase;

import java.util.ArrayList;
import java.util.List;

public class USFExample {
    public static void main(String[] args) {
        List<USFPerson> usfPeople = new ArrayList<>();
        USFPerson faculty1 = new USFFaculty("Chris Jenkins", "9013", 401);
        ((USFFaculty)faculty1).addCourse("cs673");
        ((USFFaculty)faculty1).addCourse("cs331");
        usfPeople.add(faculty1);

        usfPeople.add(new USFStudent("Michael Chen", "1046", 3.9));
        usfPeople.add(new USFStaff("Lisa Manekoffski", "2407", 321, 7));
        for (USFPerson person: usfPeople) {
            person.print(); // polymorphic behavior - different implementations of print will be invoked
            // depending on which object the "person" variable is referencing

            System.out.println("--------------");
        }
    }
}
