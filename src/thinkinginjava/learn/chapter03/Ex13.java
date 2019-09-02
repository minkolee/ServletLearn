package thinkinginjava.learn.chapter03;

import static java.lang.System.out;

public class Ex13 {

    public static void showBinaryOfChar(char c) {
        //由于移位就是除以2的结果, 所以不断的除以2即可. 但是符号要保留
        int temp = (int) (c);
        out.println(temp);
        out.println(Integer.toBinaryString(temp));
    }

    public static void main(String[] args) {
        showBinaryOfChar('9');

    }

}
