package designPatterns.structural.decorator.shapes;

//Decorator Pattern Example
//The example is based on  https://www.tutorialspoint.com/design_pattern/decorator_pattern.htm
public class BorderDecorator extends ShapeDecorator {

	public BorderDecorator(Drawable decoratedShape) {
	      super(decoratedShape);		
	   }

	   @Override
	   public void draw() {
	       getDecoratedShape().draw();
		   // Add a border
		   System.out.println("Decorate with the border");
	   }

}
