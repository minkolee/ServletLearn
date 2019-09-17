package thinkinginjava.learn.chapter15;

/**
 * 实现元组类型
 */

public class TwoTuple<A, B> {
    private final A first;
    private final B second;

    public TwoTuple(A a, B b) {
        this.first = a;
        this.second = b;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "TwoTuple{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
