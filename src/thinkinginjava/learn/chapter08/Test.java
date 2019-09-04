package thinkinginjava.learn.chapter08;

public class Test {

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        System.out.println(b.getI());
        System.out.println(a.getI());
        b.setI(1);
        System.out.println(b.getI());
        System.out.println(a.getI());
    }
}



class A {
    private int i = 10;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}


class B extends A {

}