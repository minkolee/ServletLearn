package thinkinginjava.learn.chapter03;

import static java.lang.System.out;

public class Ex11 {

    public static void main(String[] args) {
        int i = 0b11111111;
        out.println(i);

        for (; i != 0; i >>= 1) {
            out.println(Integer.toBinaryString(i));
        }
    }

}
