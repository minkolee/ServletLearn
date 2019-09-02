package thinkinginjava.learn.chapter03;

import static java.lang.System.out;

public class Ex10 {

    public static void main(String[] args) {
        int long1 = 0b10101010;
        int long2 = 0b01010101;

        out.println(Integer.toBinaryString(long1 & long2));
        out.println(Integer.toBinaryString(long1^long2));
        out.println(Integer.toBinaryString(long1|long2));
        out.println(Integer.toBinaryString(~long1));
        out.println(Integer.toBinaryString(~long2));
    }

}
