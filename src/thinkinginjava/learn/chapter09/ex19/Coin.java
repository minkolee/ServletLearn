package thinkinginjava.learn.chapter09.ex19;

import java.util.Random;

public class Coin implements Game {

    @Override
    public int play() {
        int result = new Random().nextInt(2);
        System.out.println("硬币扔出了: " + result);
        return result;
    }

}
