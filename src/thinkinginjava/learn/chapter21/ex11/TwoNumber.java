package thinkinginjava.learn.chapter21.ex11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwoNumber {

    private int first = 0;

    private int second = 1;

    //从f(0)开始产生斐波那契数列
    public synchronized int next() {

        if (first == 0) {
            update();
            return 1;
        } else {
            update();
            return first;
        }
    }

    public synchronized void update() {
        int temp = first + second;
        first = second;
        second = temp;
        Thread.yield();

    }

    public void reset() {
        first = 0;
        second = 1;
    }


    public static void main(String[] args) {
        TwoNumber twoNumber = new TwoNumber();
        for (int i = 0; i < 20; i++) {
            System.out.println(i + " :" + twoNumber.next());
        }
        System.out.println("---------------");

        twoNumber.reset();

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int j = 0; j < 20; j++) {
            executorService.submit(new Checker(twoNumber, j));
        }
        executorService.shutdown();
    }



}

class Checker extends Thread {

    private TwoNumber twoNumber;

    private int id;

    Checker(TwoNumber twoNumber, int id) {
        this.id = id;
        this.twoNumber = twoNumber;
    }

    @Override
    public void run() {
        System.out.println(id + " :" + twoNumber.next());
    }
}