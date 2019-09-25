package thinkinginjava.learn.chapter21.sync.taskend.ex21;

import java.util.concurrent.TimeUnit;

public class Run2 implements Runnable {

    private Test test;

    Run2(Test test) {
        this.test = test;
    }

    public void run() {
        try {
            System.out.println("R2开始休眠, 5秒后通知R1");
            TimeUnit.SECONDS.sleep(5);
            test.notifyAllOther();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
