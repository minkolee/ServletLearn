package thinkinginjava.learn.chapter05;

import java.util.Arrays;

public class Ex19 {

    public static void main(String[] args) {
        Test3 test3 = new Test3("vdsa", "bvc", "放1");
        Test3 test2 = new Test3(new String[]{"vcdjkkjls", "vdsjlkjklsfd"});
    }
}

class Test3 {

    Test3(String... args) {
        System.out.println(Arrays.toString(args));

    }
}