package thinkinginjava.learn.chapter03;

import static java.lang.System.out;

public class Ex14 {

    public static void compareString(String a, String b) {
        if (a.equals(b)) {
            out.println("字符串相等");
        } else {
            out.println("字符串不相等");
        }

        if (a.compareTo(b) > 0 ) {
            out.println(a + " 大于 " + b);
        } else if (a.compareTo(b) == 0) {
            out.println(a + " 等于 " + b);
        } else {
            out.println(a + " 小于  " + b);
        }

    }

    public static void main(String[] args) {
        String s1 = "saner";
        String s2 = "saner";

        compareString(s1, s2);
    }

}
