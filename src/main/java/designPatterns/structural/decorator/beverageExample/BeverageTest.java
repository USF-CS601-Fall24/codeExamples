package designPatterns.structural.decorator.beverageExample;
/** The example demonstrates how to use the Decorator pattern.
 *  The code is from Head First Design Pattern book.
 *
 */

public class BeverageTest {
 
	public static void main(String args[]) {
		Beverage beverage1 = new Espresso();
		System.out.println(beverage1.getDescription()
				+ " $" + beverage1.cost());
		beverage1 = new BeverageWithMilk(beverage1);
		beverage1 = new BeverageWithMilk(beverage1);
		System.out.println("Total cost of expresso with 2 servings of milk: " + beverage1.cost());

		/*System.out.println(beverage1.getDescription()
				+ " $" + beverage1.cost());
		beverage1 = new BeverageWithWhippedCream(beverage1);
		System.out.println(beverage1.getDescription()
				+ " $" + beverage1.cost());*/

		//Beverage beverage2 = new BeverageWithWhippedCream(new BeverageWithMilk(new Decaf()));
		Beverage beverage2 = new BeverageWithMilk(new BeverageWithMilk(new Decaf()));

		System.out.println(beverage2.getDescription()
				+ " $" + beverage2.cost());



	}
}
