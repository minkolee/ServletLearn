package thinkinginjava.learn.chapter21.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable {

    private IntGenerator intGenerator;
    private final int id;

    public EvenChecker(IntGenerator intGenerator, int ident) {
        this.intGenerator = intGenerator;
        id = ident;
    }

    @Override
    public void run() {
        while (!intGenerator.isCanceled()) {
            int val = intGenerator.next();
            if (val % 2 != 0) {
                System.out.println(val + " not even!");
                intGenerator.cancel();
            }
        }
    }

    public static void test(IntGenerator gp, int count) {

        System.out.println("Press Ctrl+C to exit.");
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            executorService.execute(new EvenChecker(gp, i));
        }
        executorService.shutdown();

    }

    public static void test(IntGenerator gp) {
        test(gp, 20);
    }
}
