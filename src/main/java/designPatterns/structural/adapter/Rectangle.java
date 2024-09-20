package designPatterns.structural.adapter;

/** Modified from https://sourcemaking.com/design_patterns/adapter/java/1 */

public class Rectangle {

	public void drawRec(int x, int y, int w, int h) {
		System.out.println("rectangle at (" + x + ',' + y + ") with width " + w + " and height " + h);
	}

}
