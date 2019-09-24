package thinkinginjava.learn.chapter21.sync;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AttempLocking {

    private ReentrantLock lock = new ReentrantLock();

    public void untimed() {
        //尝试获取锁
        boolean captured = lock.tryLock();

        try {
            System.out.println("tryLock():" + captured);

        }finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public void timed() {
        boolean captured = false;

        try {
            captured = lock.tryLock(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try{
            System.out.println("tryLock(2secons)");
        }
        finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        final AttempLocking al = new AttempLocking();
        //在main线程里上锁, 然后解锁, 正常
        al.untimed();
        al.timed();
        System.out.println("-------------");

        //匿名类直接启动一个新线程, 上锁
        new Thread(){
            {
                setDaemon(true);}

            public void run() {

                al.lock.lock();

                System.out.println("acquired");
            }
        }.start();
        //之后将控制权交给其他线程
        Thread.yield();

        //再启动一个线程调用timed()方法
        new Thread(){
            {
                setDaemon(true);}

            public void run() {

                al.timed();

            }
        }.start();
        Thread.yield();

        //再启动一个线程调用 untimed()方法
        new Thread(){
            {
                setDaemon(true);}

            public void run() {

                al.untimed();

            }
        }.start();
        Thread.yield();
    }

}

