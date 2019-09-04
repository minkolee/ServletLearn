package thinkinginjava.learn.chapter08.polymorphism.shape;

public class Shape {

    public void draw() {

    }

    public void erase() {

    }

    public int wheels() {
        return 0;
    }

    public void fatherMethod() {
        System.out.println("Shape 基类的方法调用");
    }

    public void partiallyOver() {
        System.out.println("被部分子类覆盖的基类方法");
    }
}

