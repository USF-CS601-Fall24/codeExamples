package designPatterns.creatingObjects.factoryMethod.simplePizzaFactory;

public class PizzaTestDrive {
 
	public static void main(String[] args) {
		PizzaFactory factory = new SimplePizzaFactory();
		PizzaStore store = new PizzaStore(factory);

		Pizza pizza = store.orderPizza("cheese");
		System.out.println("We ordered a " + pizza.getName() + "\n");
 
		pizza = store.orderPizza("veggie");
		System.out.println("We ordered a " + pizza.getName() + "\n");
	}
}
