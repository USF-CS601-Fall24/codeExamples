package designPatterns.structural.decorator.shapes;
//Decorator Pattern Example
//The example is based on  https://www.tutorialspoint.com/design_pattern/decorator_pattern.htm

public class DecoratorPatternDemo {
	   public static void main(String[] args) {
	      Drawable myCircle = new BorderDecorator(new ShinyDecorator(new BorderDecorator(new Circle())));
	      myCircle.draw();
	      
	      /*Drawable redRectangle = new BorderDecorator(new Rectangle());
	      redRectangle.draw();
	      */
	   }
	}