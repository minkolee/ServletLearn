package thinkinginjava.learn.chapter05;

public class Test {
    public static void main(String[] args) {
        Leaf x = new Leaf();

        x.increment().print();
        x.increment().print();

        f('c', 'd');
        g(1, 2, 3);

        System.out.println(x.getClass());
    }

    static void f(Character... args) {
        System.out.println(args.getClass());

    }

    static void g(int... args) {
        System.out.println(args.getClass());

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

