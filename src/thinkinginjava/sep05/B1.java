package thinkinginjava.sep05;

public class B1 extends A {

    public static void main(String[] args) {
        B1 b1 = new B1();
        System.out.println(b1.getS());

        b1.setS("New String set by B1");
        System.out.println(b1.getS());
    }
}
