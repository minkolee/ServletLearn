package thinkinginjava.learn.chapter03;

import static java.lang.System.out;

public class Ex12 {

    public static void main(String[] args) {
        int i = 0b1111111111;
        out.println(i);

        //被移位多少, 这个数字内部其实是只取不超过32或者64的部分, 所以二者相等
        int j = i >> 0b1000101;

        int k = i >> 0b101;

        out.println(Integer.toBinaryString(j));
        out.println(Integer.toBinaryString(k));
        out.println("---------------------------");
        for (int l = 0; l < 3; l++) {
            i = i << 1;
            out.println(Integer.toBinaryString(i));
        }

        for (; i != 0; i >>= 1) {
            out.println(Integer.toBinaryString(i));
        }
        out.println(i);
    }

}
