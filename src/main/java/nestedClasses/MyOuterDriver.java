package nestedClasses;

public class MyOuterDriver {
    public static void main(String[] args) {
        /*MyOuter outer = new MyOuter(2);
        MyOuter.MyInner inner  = outer.new MyInner();*/
        MyOuter.MyInner inner = new MyOuter(5).new MyInner();
        inner.func();
    }
}
