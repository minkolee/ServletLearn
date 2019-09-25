package thinkinginjava.learn.chapter21.sync.taskend;

import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class OrnamentalGarden {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Entrance(i));
        }

        //主线程睡三秒之后关闭所有门
        TimeUnit.SECONDS.sleep(3);
        Entrance.cancel();
        executorService.shutdown();

        if (!executorService.awaitTermination(250, TimeUnit.MILLISECONDS)) {
            System.out.println("Some tasks are not terminated");
        }
        System.out.println("--------------------------------");
        System.out.println("Total: " + Entrance.getTotalCount());
        Entrance.showAllNumber();
    }
}

// 统计人数的对象
class Count {
    private int count = 0;

    private Random rand = new Random();

    public synchronized int increment() {
        int temp = count;
        if (rand.nextBoolean()) {
            Thread.yield();

        }
        return (count = ++temp);
    }

    public synchronized int getCount() {
        return count;
    }
}

//多个门, 用于统计每个门进出的人数, 用多线程操作
class Entrance implements Runnable {

    private static Random random = new Random();

    private static Count count = new Count();

    //创建一个列表用于存放所有的线程对象, 以控制该线程
    //这和CSAPP里的使用线程号本质上一样
    private static List<Entrance> entrances = new ArrayList<>();

    //每一个门都从0个人开始统计
    private int number = 0;
    //门的id
    private final int id;
    //门是不是关闭
    private static volatile boolean canceled = false;
    //设置门关闭
    public static void cancel() {
        canceled = true;
    }

    //初始化的时候, 把新对象加入到列表中
    public Entrance(int id) {
        this.id = id;
        entrances.add(this);
    }

    public void run() {
        //在每个线程中, 定期的进一个人, 然后打印
        while (!canceled) {
            synchronized (this) {
                //自己对象里的统计当前门进了多少人
                ++number;
            }
            //打印出目前的总人数
            System.out.println(this + "Total: " + count.increment());

            try{
                TimeUnit.MILLISECONDS.sleep(random.nextInt(10) * random.nextInt(20));

            } catch (InterruptedException e) {
                System.out.println("Sleep interrupted");
            }
        }
        //运行到这里门关闭了, 就打印
        System.out.println("Door " + id + " stopped");
    }

    public synchronized int getNumber() {
        return this.number;
    }

    @Override
    public synchronized String toString() {
        return "Entrance{" +
                "id=" + id +
                ", number=" + number +
                '}';
    }

    public static int getTotalCount() {
        return count.getCount();
    }

    public static int sumEntrances() {
        int sum = 0;
        for (Entrance entrance : entrances) {
            sum += entrance.getNumber();
        }
        return sum;
    }

    public static void showAllNumber() {
        for (Entrance entrance : entrances) {
            System.out.println(entrance);
        }
    }

}
