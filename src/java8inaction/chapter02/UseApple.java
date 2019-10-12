package java8inaction.chapter02;

public class UseApple {

    public static void processApple(Apple apple, ConsumeApple consumeApple) {
        consumeApple.accept(apple);
    }


    public static void main(String[] args) {

        Apple apple = new Apple();

        processApple(apple, apple1 -> {
            System.out.println("apple is" + apple);
        });
    }
}
