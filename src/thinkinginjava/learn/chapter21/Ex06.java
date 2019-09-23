package thinkinginjava.learn.chapter21;

import java.io.RandomAccessFile;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex06 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executorService.submit(new SleepSomeTime(i));
        }
    }

}


class SleepSomeTime implements Callable<Integer> {

    private int id;
    private static Random random = new Random();

    public SleepSomeTime(int i) {
        id = i;
    }

    @Override
    public Integer call() throws Exception {
        int time = random.nextInt(10);
        Thread.sleep(time * 1000);
        System.out.println("ID " + id + " Slept for " + time + " seconds");
        return time;
    }
}