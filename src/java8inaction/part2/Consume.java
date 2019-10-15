package java8inaction.part2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Consume {

    public static void main(String[] args) {

        List<String> ss = Arrays.asList("Hello", "world!");

        ss.stream().map(s -> s.split("")).forEach(strings -> System.out.println(Arrays.toString(strings)));
        ss.stream().map(s -> s.split("")).forEach(System.out::println);

        List<String> uniqueCharacters =
                ss.stream()
                        .map(w -> w.split(""))
                        .flatMap(Arrays::stream)
                        .distinct()
                        .collect(Collectors.toList());

        System.out.println(uniqueCharacters);
    }
}
