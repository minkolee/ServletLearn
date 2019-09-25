package thinkinginjava.learn.chapter21.sync.taskend.classic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//餐馆实际上是Meal的容器, 两个线程使用同一个餐馆对象, 其中持有Meal对象, 对于容器访问, 需要加锁才行
public class Restaurant {
    Meal meal = null;
    ExecutorService exec = Executors.newCachedThreadPool();

    //这个很有意思, 直接以当前对象传给Consumer
    final Consumer consumer = new Consumer(this);
    final Chef chef = new Chef(this);

    public Restaurant() {
        exec.execute(chef);
        exec.execute(consumer);

    }

    public static void main(String[] args) {
        new Restaurant();
    }

}


//这个类就是要消费的数据.
class Meal {
    private final int number;

    public Meal(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "number=" + number +
                '}';
    }
}

//消费者, 就是把肉拿走的人
class Consumer implements Runnable {
    private Restaurant restaurant;

    public Consumer(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    //餐馆里没有肉, 就等待
                    while (restaurant.meal == null) {
                        wait();
                    }
                }
                System.out.println("Consumer got a meal");
                //消费完肉之后, 通知厨子做饭
                synchronized (restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("中断消费者");
        }
    }
}

class Chef implements Runnable {
    private Restaurant restaurant;

    private int count = 0;

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void run(){
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal != null) {
                        wait();
                    }
                }
                if (++count == 10) {
                    System.out.println("生产完了10顿饭.");
                    restaurant.exec.shutdownNow();
                }
                System.out.println("开始做饭");
                synchronized (restaurant.consumer) {
                    restaurant.meal = new Meal(count);
                    restaurant.consumer.notifyAll();
                }
                TimeUnit.SECONDS.sleep(1);
            }

        } catch (InterruptedException e) {
            System.out.println("中断厨子");
        }
    }
}