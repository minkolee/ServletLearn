package thinkinginjava.learn.chapter21.sync.taskend.ex22.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Target {

    private volatile boolean  flag = false;

    public synchronized void changeStatus() {
        flag = true;
        notifyAll();
    }

    public synchronized boolean isAvailable() {
        return flag;
    }

    public synchronized void  waitForFlag() throws InterruptedException {
        while (!flag) {
            System.out.println("检测flag " + flag);
            wait();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Target target = new Target();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new Setter(target));
        executorService.submit(new Worker(target));
        executorService.shutdown();

        System.out.println("主线程睡10秒");
        TimeUnit.SECONDS.sleep(10);
        System.out.println("主线程醒过来了");
        executorService.shutdownNow();
    }
}
