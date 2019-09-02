package thinkinginjava.learn.chapter04;

import java.util.Random;

public class Ex04 {
    //这个如果要探测素数, 运行级别是平方级别的, 太可怕了

    public static void searchPrime() {
        for (int i = 2; ; i++) {
            boolean mark = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    mark = false;
                    break;
                }
            }
            if (mark) {
                System.out.println(i + "是素数");
            }
        }
    }

    public static void main(String[] args) {
        searchPrime();

    }
}
