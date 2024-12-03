package generics;

public class MathBoxExampleWithWildcards {
	public static void main(String[] args) {
		// MathBox<Number> nBox = new MathBox<Integer>(4); // won't compile - no upcasting!
		Object myMathBox = new MathBox<Integer>(4); // ok
		System.out.println(((MathBox<Integer>)myMathBox).getData()); // ok

		MathBox<?> numBox = new MathBox<Integer>(31); // ok
		MathBox<?> numBox1 = new MathBox<Float>(0.5f); // ok
		Integer i = (Integer)numBox.getData();
		numBox = numBox1; // ok
		Float i1 = (Float)numBox.getData();
		//Integer i2 = (Integer)numBox.getData(); // compiles but will crash at runtime

		// Can not setData!
		//numBox.setData(13); // will not compile! Compiler does not know the type of numBox and if it is ok to put an integer there

		MathBox<? extends Integer> nBox = new MathBox<Integer>(31);
		Integer i3 = nBox.getData();
		System.out.println(i3);
		System.out.println(nBox.sqrt());
		// nBox.setData(6); // not ok!

		MathBox<? super Integer> numBox2 = new MathBox<>(31); // ok
		numBox2.setData(5);
		System.out.println(numBox2.getData());
	}
}
