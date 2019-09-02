package thinkinginjava.learn.chapter03;

import java.util.Random;

import static java.lang.System.identityHashCode;
import static java.lang.System.out;

public class Ex07 {

    public static void main(String[] args) {
        int i = 3;
        ThrowCoins throwCoins = new ThrowCoins(i);
        out.println(throwCoins.getResult() / (double) i);
    }

}

class ThrowCoins {

    private int times;

    ThrowCoins(int i) {
        this.times = i;
    }

    public int getResult() {
        boolean result;
        Random random = new Random();
        int upperCount = 0;

        for (int i = 0; i < times; i++) {
            result = random.nextInt() % 2 == 0;
            if (result) {
                out.println("第" + (i + 1) + "次: 正面");
                upperCount++;
            } else {
                out.println("第" + (i + 1) + "次: 反面");
            }
        }
        out.println("总共有" + upperCount + "次为正面");
        return upperCount;
    }

}