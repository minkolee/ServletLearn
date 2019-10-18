package java8inaction.part3;

public interface B {
    default void hello() {
        System.out.println("Hello from B");
    }
}