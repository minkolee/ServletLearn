package java8inaction.part3;

public interface A {
    default void hello() {
        System.out.println("Hello from A");
    }
}

