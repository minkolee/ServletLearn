package thinkinginjava.learn.chapter09;

import thinkinginjava.sep05.A;

public class Ex04 {

    //抽象类只要存在方法, 就可以多态, 无需向下转型了.

    public static void main(String[] args) {
        A04s a04s = new A04s();
        A04s.printo(a04s);

    }

}

abstract class A04 {
    abstract void print();
}

class A04s extends A04 {

    public static void printo(A04 a04) {

        a04.print();
    }

    public void print() {
        System.out.println("sauner");

    }
}