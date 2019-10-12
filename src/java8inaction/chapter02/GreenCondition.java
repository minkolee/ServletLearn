package java8inaction.chapter02;

public class GreenCondition implements Condition {

    public  boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
