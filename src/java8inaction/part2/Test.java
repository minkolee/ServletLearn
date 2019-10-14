package java8inaction.part2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {


    public static void main(String[] args) {

        //一个Dish的List
        List<Dish> dishes = Dish.getMenu();

        //转换成一个Dish的流
        Stream<Dish> dishes1 = dishes.stream();



        List<String> newDishes = dishes.stream()
                //过滤, 其中是一个Predicate, 可以传入lambda
                .filter(dish -> dish.getCalories() > 300)
                //map方法表示接受一个lambda, 将元素转换成其他形式, map的意思表示对每个元素应用其中的lambda表达式, 收集应用后的结果
                .map(dish -> dish.getName())
                //获取前三个
                .limit(3)
                //收集成一个列表
                .collect(Collectors.toList());

        System.out.println(newDishes);
    }
}
