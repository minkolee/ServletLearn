package thinkinginjava.learn.chapter21;


public class Ex01 implements Runnable {

    public Ex01() {
        System.out.println("Task is about to start...");
    }

    @Override
    public void run() {
        System.out.println("This is tasking running step1...");
        Thread.yield();
        System.out.println("This is tasking running step2...");
        Thread.yield();
        System.out.println("This is tasking running step3...");
        Thread.yield();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1024; i++) {
            Thread t = new Thread(new Ex01());
            t.start();
        }
    }
}
