package inheritance.abstractClasses;
//********************************************************************
//  Firm.java       Author: Lewis/Loftus
//
//  Demonstrates polymorphism via inheritance.
//********************************************************************

public class Firm {
	
	// -----------------------------------------------------------------
	// Creates a staff of employees for a firm and pays them.
	// -----------------------------------------------------------------
	public static void main(String[] args) {
		Staff personnel = new Staff();

		personnel.payday();

		Employee e1 = new Employee("Alice", "","","",5000.0);

		Hourly e2 = new Hourly("Cindy", "", "", "",20.0);
		e2.addHours(10);

		Employee e3 = new Hourly("Anne", "", "", "", 30.0);
		((Hourly)e3).addHours(10);
		System.out.println(e3.pay());
	}
}