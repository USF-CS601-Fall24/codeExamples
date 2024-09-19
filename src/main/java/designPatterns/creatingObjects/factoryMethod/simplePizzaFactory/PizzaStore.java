package designPatterns.creatingObjects.factoryMethod.simplePizzaFactory;

/** Using a simple factory. This is better than PizzaStoreV1, since we encapsulated things that may change */
public class PizzaStore {
	private PizzaFactory factory;
 
	public PizzaStore(PizzaFactory factory) {
		this.factory = factory;
	}
 
	public Pizza orderPizza(String type) {
		Pizza pizza;
		pizza = factory.createPizza(type); // would not need to change anything in thi class if we want to add a different type of pizza.
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();

		return pizza;
	}

}
