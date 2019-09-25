package thinkinginjava.learn.chapter21.sync.taskend.ex22.Test;

import java.util.concurrent.TimeUnit;

public class Setter implements Runnable {

    private Target target;

    Setter(Target target) {
        this.target = target;
    }

    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("休眠: " + (i + 1));
                TimeUnit.SECONDS.sleep(1);
            }
            target.changeStatus();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
