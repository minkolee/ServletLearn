package thinkinginjava.learn.chapter21;

public class Joining {
    public static void main(String[] args) {
        Sleeper sleepy = new Sleeper("Sleepy", 1500);
        Sleeper grumpy = new Sleeper("Grumpy", 1500);

        Joiner
//                dopey去等待sleepy, doc去等待Grumpy
                dopey = new Joiner("Dopey", sleepy),
                doc = new Joiner("Doc", grumpy);
        //打断睡眠中的Grumpy, 由于睡眠之后没有语句, 打断结束线程会结束, 等待该线程的线程也会结束
        grumpy.interrupt();

    }

}


class Sleeper extends Thread {
    private int duration;

    public Sleeper(String name, int sleepTime) {
        super(name);
        duration = sleepTime;
        start();
    }

    public void run() {
        try {
            sleep(duration);

        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted." + "isInterrupted(): " + isInterrupted());
            return;
        }
        System.out.println(getName() + "has awakened");
    }
}

class Joiner extends Thread {
    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        //开始运行此线程, 虚拟机会调用run()方法
        start();
    }

    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");

        }
        System.out.println(getName() + " join completed");
    }
}
