package thinkinginjava.learn.chapter03;

public class Test {

    public static void main(String[] args) {
        int i1 = 0xff;
        System.out.println("i1: " + Integer.toBinaryString(i1));

        char c = 0xff;

        //这里其实隐含的是, b是有符号的数字 ,否则单字节不会放不下0xff
        byte b = -0x80;

        System.out.println(b);

        double dd = 29.7;
        System.out.println((int) dd);
        System.out.println(Math.round(dd));

    }
}
