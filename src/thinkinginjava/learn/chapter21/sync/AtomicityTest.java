package thinkinginjava.learn.chapter21.sync;

import thinkinginjava.sep05.A;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicityTest implements Runnable {

    private int i = 0;

    public synchronized int getI() {
        return i;
    }

    private synchronized void evenIncrement() {
        i++;
        Thread.yield();
        i++;
    }

    @Override
    public void run() {
        while (true) {
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        AtomicityTest atomicityTest = new AtomicityTest();
        //启动无限自增2的任务
        executorService.execute(atomicityTest);

        //新启动一个线程不断去读i的值, 读取到奇数就打印并终止
        new Thread(() -> {
            while (true) {
                int val = atomicityTest.getI();
                if (val % 2 != 0) {
                    System.out.println(val);
                    System.exit(0);
                }
            }
        }).start();

    }
}
