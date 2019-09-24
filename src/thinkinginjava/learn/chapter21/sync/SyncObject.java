package thinkinginjava.learn.chapter21.sync;

public class SyncObject {
    public static void main(String[] args) {
        final DualSynch dualSynch = new DualSynch();

        //起一个新线程执行f()
        new Thread() {
            @Override
            public void run() {
                dualSynch.f();
            }
        }.start();

        //Main线程中执行g()
        dualSynch.g();

    }
}

class DualSynch {
    private Object syncObject = new Object();

    //默认的synchronized采用本身对象
    public synchronized void f() {
        for (int i = 0; i < 5; i++) {
            System.out.println("f()");
            Thread.yield();
        }
    }

    //这个使用了另外一个账户
    public void g() {
        synchronized (syncObject) {
            for (int i = 0; i < 5; i++) {
                System.out.println("g()");
                Thread.yield();
            }
        }
    }

}
