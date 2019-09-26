package thinkinginjava.learn.chapter21.sync.taskend;

import thinkinginjava.learn.chapter21.LiftOff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TestBlockingQueue {

    static void getKey() {
        try {
            new BufferedReader(new InputStreamReader(System.in)).readLine();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void getKey(String message) {
        System.out.println(message);
        getKey();
    }

    static void test(String msg, BlockingQueue<LiftOff> queue) {
        System.out.println(msg);
        LiftOffRunner runner = new LiftOffRunner(queue);
        Thread t = new Thread(runner);
        t.start();
        for (int i = 0; i < 5; i++) {
            runner.add(new LiftOff(5));

        }
        getKey("Press Enter: +" + msg);
        t.interrupt();

    }

    public static void main(String[] args) {
        test("LinkedBlockingQueue", new LinkedBlockingQueue<LiftOff>());

    }

}

class LiftOffRunner implements Runnable {
    private BlockingQueue<LiftOff> rockets;

    public LiftOffRunner(BlockingQueue<LiftOff> queue) {
        rockets = queue;
    }

    public void add(LiftOff liftOff) {
        try {
            rockets.put(liftOff);

        } catch (InterruptedException e) {
            System.out.println("在put()中被打断");
        }
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                //用take()方法取一个的对象, 如果没有, 就会阻塞
                LiftOff rocket = rockets.take();
            }
        } catch (InterruptedException e) {
            System.out.println("休眠中被叫醒");
        }
        System.out.println("执行 LiftOffRunner");
    }




}
