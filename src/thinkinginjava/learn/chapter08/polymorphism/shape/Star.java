package thinkinginjava.learn.chapter08.polymorphism.shape;

public class Star extends Shape {


    //练习4添加的新的Star类
    @Override
    public void draw() {
        System.out.println("Star draw()");
    }

    @Override
    public void erase() {
        System.out.println("Star erase()");
    }

    @Override
    public void partiallyOver() {
        System.out.println("Star类覆盖了基类的方法");
    }

    @Override
    public int wheels() {
        return 5;
    }
}
