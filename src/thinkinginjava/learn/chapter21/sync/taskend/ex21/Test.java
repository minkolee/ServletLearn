package thinkinginjava.learn.chapter21.sync.taskend.ex21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {

    private static boolean watcher = false;

    public synchronized void changeStatus() throws InterruptedException {
        wait();
        watcher = true;
    }

    public synchronized void notifyAllOther() {
        notifyAll();
    }

    public static void main(String[] args) throws InterruptedException {

        Test test = new Test();

        Run1 run1 = new Run1(test);

        Run2 run2 = new Run2(test);

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.submit(run1);
        executorService.submit(run2);
        executorService.shutdown();
        TimeUnit.SECONDS.sleep(10);

    }


}
