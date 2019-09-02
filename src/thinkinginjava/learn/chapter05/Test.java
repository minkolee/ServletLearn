package thinkinginjava.learn.chapter05;

public class Test {
    public static void main(String[] args) {
        Leaf x = new Leaf();

        x.increment().print();
        x.increment().print();
    }
}

class Leaf {
    private int i = 0;

    Leaf increment() {
        i++;
        return this;
    }

    void print() {
        System.out.println("i= " + i);
    }
}