package thinkinginjava.learn.chapter21.sync;

public class EvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;

    @Override
    public synchronized int next() {
        //自增1
        ++currentEvenValue;

        Thread.yield();

        ++currentEvenValue;

        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());

    }

}
