package inheritance.abstractClasses;
//********************************************************************
//Employee.java       Author: Lewis/Loftus
//
//Represents a general paid employee.
//********************************************************************

public class Employee extends StaffMember {
	private String socialSecurityNumber;
	private double payRate;

	// -----------------------------------------------------------------
	// Constructor: Sets up this employee with the specified
	// information.
	// -----------------------------------------------------------------
	public Employee(String eName, String eAddress, String ePhone, String socSecNumber, double rate) {
		super(eName, eAddress, ePhone);

		socialSecurityNumber = socSecNumber;
		payRate = rate;
	}

	// -----------------------------------------------------------------
	// Returns information about an employee as a string.
	// -----------------------------------------------------------------
	@Override
	public String toString() {
		String result = super.toString();

		result += "\nSocial Security Number: " + socialSecurityNumber;

		return result;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public double getPayRate() {
		return payRate;
	}

	// -----------------------------------------------------------------
	// Returns the pay rate for this employee.
	// -----------------------------------------------------------------
	@Override
	public double pay() {
		return payRate;
	}
}