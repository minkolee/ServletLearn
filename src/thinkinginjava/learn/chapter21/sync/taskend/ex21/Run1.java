package thinkinginjava.learn.chapter21.sync.taskend.ex21;

public class Run1 implements Runnable {

    private Test test;

    Run1(Test test) {
        this.test = test;
    }

    @Override
    public void run() {
        try {
            System.out.println("R1开始等待");
            test.changeStatus();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("R1得到notify通知, 结束了等待");
    }
}
