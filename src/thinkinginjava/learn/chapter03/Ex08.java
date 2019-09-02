package thinkinginjava.learn.chapter03;

import static java.lang.System.out;

public class Ex08 {

    public static void main(String[] args) {

        //八进制是零开头
        byte a = 030;

        out.println(a);

        //这个赋值不行, 超过了正数范围
//        byte b = 0xff;

        byte c = 0x7f;

        //如果要-128, 要这么赋值, 这个和C系语言很不同
        byte d = -0x80;
    }

}
