package thinkinginjava.learn.chapter21.sync.activeobject;

import thinkinginjava.sep05.A;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class ActiveObjectDemo {

    //事件驱动的情况下, 用单个线程就足够了
    //这个单线程的执行器, 本身就维护着一个单线程的队列, 向其中不断添加新任务的时候, 也是单线程执行完一个再执行一个
    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    private Random random = new Random(47);

    private void pause(int factor) {
        try {
            TimeUnit.MILLISECONDS.sleep(100 + random.nextInt(factor));

        } catch (InterruptedException e) {
            System.out.println("睡眠被打断");
        }
    }

    public Future<Integer> calculateInt(final int x, final int y) {
        return executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("starting " + x + " + " + y);
                pause(500);
                return x + y;
            }
        });
    }

    public Future<Float> calculateFloat(final float x, final float y) {
        return executorService.submit(new Callable<Float>() {
            @Override
            public Float call() throws Exception {
                System.out.println("starting " + x + " + " + y);
                pause(500);
                return x + y;
            }
        });
    }

    public void shutdown() {
        executorService.shutdown();
    }

    public static void main(String[] args) {
        ActiveObjectDemo a1 = new ActiveObjectDemo();

        //实际上是把从submit()方法 返回的 future对象放入一个列表中
        List<Future<?>> results = new CopyOnWriteArrayList<Future<?>>();

        for (float f = 0.0f; f < 1.0f; f += 0.2f) {
            results.add(a1.calculateFloat(f, f));
        }

        for (int i = 0; i < 5; i++) {
            results.add(a1.calculateInt(i, i));
        }

        System.out.println("所有异步任务都添加完毕");

        //然后遍历列表看看是否执行完毕
        while (results.size() > 0) {
            for (Future<?> f : results) {
                //检查Future对象的是否工作完毕会立刻返回, 不会阻塞
                //这样可以不断的检查已经提交的任务是否完成了, 直到全部结束, 由于当前main方法干的事是一个线程提交任务和检查任务, 而使用executorService作为另外一个线程处理任务.
                if (f.isDone()) {
                    try {
                        System.out.println(f.get());

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                    //从列表里去掉拿出来的东西
                    results.remove(f);
                }
            }
        }
        a1.shutdown();
    }

}
