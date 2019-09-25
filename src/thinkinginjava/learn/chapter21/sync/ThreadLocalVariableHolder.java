package thinkinginjava.learn.chapter21.sync;

import thinkinginjava.learn.chapter08.polymorphism.shape.RandomShapeGenerator;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Accessor implements Runnable {

    private final int id;

    public Accessor(int idn) {
        id = idn;
    }

    @Override
    public void run() {
        //先设置一个随机0-99的值
        ThreadLocalVariableHolder.set(new Random().nextInt(100));
        //然后不断自增, 看每个线程的变量是否互相影响
        while (!Thread.currentThread().isInterrupted()) {
            ThreadLocalVariableHolder.increment();
            System.out.println(this);
            Thread.yield();
        }
    }

    @Override
    public String toString() {
        return "#" + id + ": " + ThreadLocalVariableHolder.get();
    }
}

public class ThreadLocalVariableHolder {

    //一般ThreadLocal对象可以做成一个静态的,这里创建一个int类型的ThreadLocal对象
    private static ThreadLocal<Integer> value = new ThreadLocal<>();

    //自增1然后设置新的值, 这些值由于都互相独立, 所以根本不需要同步
    public static void increment() {
        value.set(value.get() + 1);
    }

    public static void set(int i) {
        value.set(i);
    }


    //获取值
    public static int get() {
        return value.get();
    }

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        //启动10个线程, 自己读写自己的变量,互相不会冲突
        for (int i = 0; i < 3; i++) {
            executorService.submit(new Accessor(i));
        }
        //main线程3秒之后退出, 可以看到各个线程自增的数字互相不影响
        TimeUnit.MILLISECONDS.sleep(300);
        executorService.shutdown();
        System.exit(0);
    }
}