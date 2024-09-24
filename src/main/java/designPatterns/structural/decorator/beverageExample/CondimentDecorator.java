package designPatterns.structural.decorator.beverageExample;

/**  The code is from Head First Design Pattern book.
 *
 */
public abstract class CondimentDecorator extends Beverage {
	private Beverage beverage;

	public CondimentDecorator(Beverage beverage) {
		super();
		this.beverage = beverage;
	}

	public abstract String getDescription();

	protected Beverage getBeverage() {
		return beverage;
	}
}
