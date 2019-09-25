package thinkinginjava.learn.chapter21.sync.taskend.ex22.Test;

public class Worker implements Runnable {

    private Target target;

    Worker(Target target) {
        this.target = target;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis()/1000;
        try {
            target.waitForFlag();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("等待完成, 干活了");
        long end = System.currentTimeMillis()/1000;
        System.out.println("总耗时:" + (start + end));
    }
}
