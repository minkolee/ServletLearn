package java8inaction.part2;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class ReduceTest {

    public static void main(String[] args) {

        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 3, 8, 9, 9, 0};

        Arrays.stream(a).map(s -> s * 3 + 1).forEach(System.out::println);
    }

}
