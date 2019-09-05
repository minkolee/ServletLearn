package thinkinginjava.learn.chapter09.ex19;

import java.util.Random;

public class Touzi implements Game {

    @Override
    public int play() {
        int result = new Random().nextInt(6);
        System.out.println("骰子扔出了: " + result);
        return result;
    }

}
