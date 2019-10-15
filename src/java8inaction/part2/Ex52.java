package java8inaction.part2;

import java.util.Arrays;

public class Ex52 {

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3};
        int[] a2 = {2, 3, 4};

        //想法, 用一个流和另外一个流生成对象, 再扁平化展开就可以了, 试验一下吧
        //这是将a1和一个数字10转换成一个Tuple流的代码, 现在要解决的就是把10改成来自于另外一个流
        Arrays.stream(a1).mapToObj(operand -> new Tuple<Integer>(operand, 10)).forEach(System.out::println);


        //对于a1中的每一个int, 返回一个Arrays.stream(a2).mapToObj(last -> new Tuple<Integer>(first, last))

        //Arrays.stream(a2).mapToObj(last -> new Tuple<Integer>(first, last)) 是针对a2中的每个int 将其换成一个Tuple的流.

        //这样执行完之后, 实际上就得到了一个所有的元素都是流的流对象
        Arrays.stream(a1).mapToObj(first ->
                Arrays.stream(a2).mapToObj(last -> new Tuple<Integer>(first, last))
        ).forEach(s -> System.out.println(s.getClass()));

        //然后就需要展开了, 由于其中每一个流已经是流了, flatMap这里无需做任何处理
        Arrays.stream(a1).mapToObj(first ->
                Arrays.stream(a2).mapToObj(last -> new Tuple<Integer>(first, last))
        ).flatMap(s -> s).distinct().forEach(System.out::println);


    }
}
