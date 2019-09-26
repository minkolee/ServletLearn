package thinkinginjava.learn.chapter21.sync.taskend;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 解决带有缓冲区的单个生产者和消费者的问题
 * 初步想法是先随便弄一个数据对象
 * 然后弄一个缓冲区对象持有数据对象
 * 然后弄一个内部索引, 不断的循环取数据, 放数据的标记一旦到达长度就要wait(), 取数据取成0之后也要wait()
 */

//
public class Ex24 {

    public static void main(String[] args) throws InterruptedException {
        Buffer buffer = Buffer.getBuffer(20);

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 1; i++) {
            executorService.execute(new Producer(buffer));

        }
        for (int j = 0; j < 3; j++) {
            executorService.execute(new Consumer(buffer));
        }

        TimeUnit.SECONDS.sleep(3);
        executorService.shutdownNow();
        System.out.println(buffer);
    }




}

//这个作为数据对象
class Data {

//    public static synchronized Data getData() {
//        return new Data(anInt++);
//    }
//
    private int number;
//
//    private static volatile int anInt = 0;

    public Data(int i) {
        this.number = i;
    }

    @Override
    public String toString() {
        return "Data{" +
                "number=" + number +
                '}';
    }
}

//Buffer类作为数据对象的持有者
//有一个取出数据的方法, 一个放入数据的方法, 用于同步
//还需要有可以取出几个和可以放入几个的标志
class Buffer {

    //用工厂模式
    public static Buffer getBuffer(int i) {
        if (i <= 0) {
            throw new RuntimeException("长度必须大于0");
        }
        return new Buffer(i);
    }

    private Data[] datas;

    //用两个索引保存上次放入数据开始的地方, 和放完数据后的位置
    private int lastIndex = 0;
    private int currentIndex = 0;

    //缓冲区长度
    private int length;
    //一开始有几个空槽可以放入数据, 设置为和长度一样
    private int availableToPut;
    //一开始有几个空槽可以取出数据, 设置为0
    private int avaiableToGet = 0;

    //私有构造器, 用工厂模式创建新的Buffer
    private Buffer(int i) {
        this.length = i;
        this.availableToPut = length;
        //初始化一个Data对象的数组, 全部初始化为null
        datas = new Data[i];
        for (int j = 0; j < length; j++) {
            datas[j] = null;
        }
    }

    //放入数据
    public synchronized void putData(Data data) throws InterruptedException {

        //如果可以放入数据的数量为0,就阻塞
        while (availableToPut == 0) {
            wait();
        }
        //如果成功通过阻塞, 说明可以放入数据了, 就放入数据, 同时更新相关指标
        //更新currentIndex到最新的可以放入数据的位置
        datas[currentIndex] = data;
        currentIndex++;
        currentIndex = currentIndex % length;

        //更新可用槽位和可读槽位
        availableToPut--;
        avaiableToGet++;
        //当前线程取出数据后唤醒其他放入数据,也就是生产者线程
        notifyAll();
//        System.out.println("成功放入了数据, 当前状态是: " + this);
    }

    public synchronized Data getData() throws InterruptedException {
        while (avaiableToGet == 0) {
            wait();
        }

        //从上次放入数据的地方取数据, 然后更新lastindex
        Data result = datas[lastIndex];
        lastIndex++;
        lastIndex = lastIndex % length;
        availableToPut++;
        avaiableToGet--;
        //当前线程取出数据后唤醒其他写入数据, 也就是消费者线程
        notifyAll();
//        System.out.println("成功取出了数据, 当前状态是: " + this);
        return result;
    }

    @Override
    public String toString() {
        return "Buffer{" +
                "datas=" + Arrays.toString(datas) +
                ", lastIndex=" + lastIndex +
                ", currentIndex=" + currentIndex +
                ", length=" + length +
                ", availableToPut=" + availableToPut +
                ", avaiableToGet=" + avaiableToGet +
                ", 尚未取出的数据等于=" + (currentIndex >= lastIndex ? currentIndex - lastIndex : currentIndex - lastIndex + length) +
                '}';
    }
}

class Producer implements Runnable {

    private static volatile int number = 0;

    private static Random random = new Random();

    private final Buffer buffer;

    Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public static synchronized int getNumber() {
        int temp = number;
        number++;
        return temp;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Data newData = new Data(Producer.getNumber());
                TimeUnit.MILLISECONDS.sleep(random.nextInt(30) * random.nextInt(20));
                System.out.println("生产者尝试放入新数据:" + newData);
                buffer.putData(newData);
            }
        } catch (InterruptedException e) {
            System.out.println("生产者被中断了");
        }

    }
}

class Consumer implements Runnable {
    private static Random random = new Random();

    private final Buffer buffer;

    Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(30) * random.nextInt(20));
                Data data = buffer.getData();
                System.out.println("消费者取出了数据: " + data);
            }

        } catch (InterruptedException e) {
            System.out.println("消费者被中断了");
        }
    }
}




















