package designPatterns.structural.decorator.beverageExample;

import java.util.List;

/** Class Beverage, a super class for two types of coffee drinks: Expresso and Decaf
 * The code is from Head First Design Pattern book.
 *
 */
public abstract class Beverage {
	private String description;

	public Beverage() {
		description = "Unknown Beverage";
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public abstract double cost();
	
}
