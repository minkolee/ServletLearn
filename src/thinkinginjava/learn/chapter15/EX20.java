package thinkinginjava.learn.chapter15;

public class EX20{
    public static void main(String[] args) {
        Test1 test1 = new Test1();

        Test2 test2 = new Test2();

        test2.test(test1);
    }
}


class Test2 {


    public <T extends Test1> void test(T t) {
        t.f();
        t.g();
        t.h();
    }

}


interface I1 {
    void f();

    void g();
}

class Test1 implements I1 {
    @Override
    public void f() {
        System.out.println("f()");
    }

    @Override
    public void g() {
        System.out.println("g()");
    }

    public void h() {
        System.out.println("h()");
    }
}