package java8inaction.part2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {

        //一个Dish的List
//        List<Dish> dishes = Dish.getMenu();
//
//        Optional<Dish> dish = dishes.stream().findFirst();
//
//        System.out.println(dish.get());


        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integers.add(i);
        }

        System.out.println(integers);

        Optional<Integer> integer = integers.stream().reduce((a, b) -> (a + b));

        System.out.println(integer.orElse(-1));

        int reduce = integer.stream().reduce(-45, (a, b) -> a + b);
        System.out.println(reduce);

    }
}
