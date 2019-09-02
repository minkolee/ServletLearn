package thinkinginjava.learn.chapter05;

import Base.Count;

public class Ex08 {

    public static void main(String[] args) {
        Counter counter = new Counter();
        counter.increment();
        System.out.println(counter.getCount());
        counter.incrementTwice();
        System.out.println(counter.getCount());

    }
}

class Counter {

    private int i;

    public void increment() {
        i++;
    }

    public void incrementTwice() {
        increment();
        increment();
    }

    public int getCount() {
        return i;
    }
}