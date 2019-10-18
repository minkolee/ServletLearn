package java8inaction.part3;

public class C implements B, A {

    @Override
    public void hello() {
        B.super.hello();
    }

    public static void main(String... args) {
        new C().hello();
    }
}
