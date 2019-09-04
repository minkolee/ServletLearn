package thinkinginjava.learn.chapter07;

public class Ex05 {

    public static void main(String[] args) {

        //创建一个C的对象, 先执行父类构造器, 然后是B
        C c = new C();
    }
}

class A {
    A() {
        System.out.println("A构造器");
    }
}

class B {
    B() {
        System.out.println("B构造器");

    }
}

class C extends A {

    B b = new B();
}