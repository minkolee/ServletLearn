package thinkinginjava.learn.chapter08.polymorphism.shape;

public class Square extends Shape {

    @Override
    public void draw() {
        System.out.println("Square draw()");

    }

    @Override
    public void erase() {
        System.out.println("Square erase()");
    }

    @Override
    public void partiallyOver() {
        System.out.println("Square类覆盖了基类的方法");
    }

    @Override
    public int wheels() {
        return 4;
    }
}
