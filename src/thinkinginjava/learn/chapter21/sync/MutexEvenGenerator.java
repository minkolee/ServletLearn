package thinkinginjava.learn.chapter21.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexEvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;

    //可重入锁对象
    private Lock lock = new ReentrantLock();

    @Override
    public synchronized int next() {
        lock.lock();
        try {

            ++currentEvenValue;
            ++currentEvenValue;

        } finally {
            lock.unlock();
        }
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new MutexEvenGenerator());

    }

}
