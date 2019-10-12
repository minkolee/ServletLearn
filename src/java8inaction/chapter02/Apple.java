package java8inaction.chapter02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Apple {

    private String color;

    public Apple() {
        Random random = new Random();
        if (random.nextBoolean()) {
            color = "red";
        } else {
            color = "green";
        }
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                '}';
    }

    public static void main(String[] args) {

        List<Apple> apples = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            apples.add(new Apple());
        }
        System.out.println(apples);

        List<Apple> greenApples = filterApples(apples, (a) -> "green".equals(a.getColor()));

        System.out.println(greenApples);

    }

    public static List<Apple> filterApples(List<Apple> inventory, Condition condition) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (condition.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }


}
