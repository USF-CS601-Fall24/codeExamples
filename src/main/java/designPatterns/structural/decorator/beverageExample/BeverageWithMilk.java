package designPatterns.structural.decorator.beverageExample;

/** The decorator: adds Milk to the Beverage
 *  The code is modified from Head First Design Pattern book.
 *
 */
public class BeverageWithMilk extends CondimentDecorator {

	public BeverageWithMilk(Beverage beverage) {
		super(beverage);
	}

	@Override
	public String getDescription() {
		return getBeverage().getDescription() + ", Milk";
	}

	@Override
	public double cost() {
		return .10 + getBeverage().cost(); // 0.10 is the cost of milk we are adding
	}

}
