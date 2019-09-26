package thinkinginjava.learn.chapter21.sync.taskend;

import requestlearn.Receive;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PipedIO {

    public static void main(String[] args) throws IOException, InterruptedException {
        Sender sender = new Sender();

        PipedReader in = new PipedReader(sender.getPipedWriter());

        Receiver receiver0 = new Receiver(sender,0, in);
        Receiver receiver1 = new Receiver(sender,1, in);
        Receiver receiver2 = new Receiver(sender,2, in);

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(sender);
        executorService.execute(receiver0);
        executorService.execute(receiver1);
        executorService.execute(receiver2);

        TimeUnit.SECONDS.sleep(20);
        executorService.shutdownNow();
    }
}


class Sender implements Runnable {

    private Random random = new Random(47);
    private PipedWriter out = new PipedWriter();

    public PipedWriter getPipedWriter() {
        return out;
    }

    public void run() {
        try {
            while (true) {
                for (char c = 'A'; c <= 'z'; c++) {
                    out.write(c);
                    TimeUnit.MILLISECONDS.sleep(500);
                }
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("IO错误或者被打断");
        }
    }
}

class Receiver implements Runnable {

    private PipedReader in;

    private int number;

    public Receiver(Sender sender, int i, PipedReader in) throws IOException {
        this.in = in;
        this.number = i;
        //这个是关键, PipedReader以一个PipedWriter对象作为构造器参数, 获取一个Reader对象
//        in = new PipedReader(sender.getPipedWriter());
    }

    public void run() {
        try {
            while (true) {
                //这里直接调用read()方法即可, 如果读完了, 会阻塞.
                char c = (char) in.read();
                System.out.println("ID: " + number + " " + c);
            }
        } catch (IOException e) {
            System.out.println("被打断");
        }
    }

}