package thinkinginjava.learn.chapter21.sync.taskend;

import java.util.concurrent.ExecutorService;
        import java.util.concurrent.Executors;
        import java.util.concurrent.TimeUnit;

public class WaxOnMatic {

    public static void main(String[] args) throws InterruptedException {
        Car car = new Car();

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new WaxOn(car));
        executorService.submit(new WaxOff(car));

        TimeUnit.SECONDS.sleep(10);
        //前边学的, 给所有线程发送interrupt信号, 我们靠这个机制结束线程
        executorService.shutdownNow();
    }
}


class Car {

    //有了四个方法之后, 打蜡的任务需要使用两个方法, 即打完腊通知其他线程干活, 以及检查打蜡标记, 如果已经打完腊, 就继续等待
    //抛光的任务则需要使用抛完光再通知其他线程干活, 以及检查抛光标记, 已经抛光过就一直等待

    //打蜡标记同时也是抛光标记, 为false的是表示抛光完成, 为true的时候表示打完腊
    private boolean waxOn = false;

    public synchronized void waxed() {
        //干完打蜡就通知所有线程干活
        waxOn = true;
        notify();
    }

    public synchronized void buffed() {
        //干完抛光就通知其他线程
        waxOn = false;
        notify();
    }

    public synchronized void waitForWaxing() throws InterruptedException {
        //如果没打蜡就继续等待
        while (!waxOn) {
            wait();
        }
    }

    public synchronized void waitForBuffed() throws InterruptedException {
        //如果没抛光就继续等待
        while (waxOn) {
            wait();
        }
    }
}

class WaxOn implements Runnable {
    private Car car;

    public WaxOn(Car car) {
        this.car = car;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("开始打蜡.");
                TimeUnit.MILLISECONDS.sleep(500);
                //打蜡
                car.waxed();
                //等抛光
                car.waitForBuffed();

            }
            //用了try-catch, 打断任务实际上变成了终止线程的工具
        } catch (InterruptedException e) {
            System.out.println("打蜡任务被中断 Interrupted");

        }
        System.out.println("结束打蜡任务");
    }
}

class WaxOff implements Runnable {
    private Car car;

    WaxOff(Car car) {
        this.car = car;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                //注意这里的顺序, 先等待, 再执行, 多个任务的话, 要有一个先执行并且改变标记, 其他的任务等待标记改变之后再来
                car.waitForWaxing();
                System.out.println("开始抛光");
                TimeUnit.MILLISECONDS.sleep(300);
                car.buffed();
            }
        } catch (InterruptedException e) {
            System.out.println("抛光任务被中断 Interrupted");

        }
        System.out.println("结束抛光任务");
    }

}