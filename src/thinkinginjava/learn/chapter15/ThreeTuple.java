package thinkinginjava.learn.chapter15;

/**
 * 实现元组类型
 */

public class ThreeTuple<A, B, C> extends TwoTuple<A, B> {
    private final C third;

    public ThreeTuple(A a, B b, C c) {
        super(a, b);
        this.third = c;
    }

    public C getThird() {
        return third;
    }

    @Override
    public String toString() {
        return "ThreeTuple{" + "first=" + this.getFirst() + ", second=" + this.getSecond() +
                ", third=" + third +
                '}';
    }
}
