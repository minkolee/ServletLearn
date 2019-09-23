package thinkinginjava.learn.chapter21;

import thinkinginjava.sep05.A;

import java.util.ArrayList;
import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        ArrayList<Future<String>> arrayList = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            arrayList.add(executorService.submit(new TaskWithResult(i)));
        }

        for (Future<String> fs : arrayList) {
            try{
                if (fs.isDone()) {
                    System.out.println(fs.get());
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                executorService.shutdown();
            }
        }
    }

}


class TaskWithResult implements Callable<String> {

    private int id;

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult: " + System.currentTimeMillis() % 59;
    }

    public TaskWithResult(int i) {
        this.id = i;
    }

}
