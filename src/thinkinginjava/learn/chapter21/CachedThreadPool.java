package thinkinginjava.learn.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 100; i++) {
            executorService.execute(new LiftOff());
        }

        //阻止新任务提交
        executorService.shutdown();

    }
}
