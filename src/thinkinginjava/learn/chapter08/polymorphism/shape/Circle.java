package thinkinginjava.learn.chapter08.polymorphism.shape;

public class Circle extends Shape {

    @Override
    public void draw() {
        System.out.println("Circle draw()");
    }

    @Override
    public void erase() {
        System.out.println("Circle erase()");
    }

    @Override
    public void partiallyOver() {
        System.out.println("Circle类覆盖了基类的方法");
    }

    @Override
    public int wheels() {
        return 1;
    }

}
