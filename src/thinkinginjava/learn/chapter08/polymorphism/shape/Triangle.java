package thinkinginjava.learn.chapter08.polymorphism.shape;

public class Triangle extends Shape {

    @Override
    public void draw() {
        System.out.println("Triangle draw()");

    }

    @Override
    public void erase() {
        System.out.println("Triangle erase()");
    }

    @Override
    public void partiallyOver() {
        System.out.println("Triangle类覆盖了基类的方法");
    }

    @Override
    public int wheels() {
        return 3;
    }
}
