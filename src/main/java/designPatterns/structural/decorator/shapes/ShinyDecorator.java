package designPatterns.structural.decorator.shapes;

public class ShinyDecorator extends ShapeDecorator {
    public ShinyDecorator(Drawable decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        getDecoratedShape().draw();
        // Add a shiny border
        System.out.println("Decorate with shiny colors");
    }
}
