package thinkinginjava.learn.chapter09.ex18;

public class Test {
    public static void testFactory(CycleFactory cycleFactory) {
        Cycle s = cycleFactory.getCycle();
        s.ride();
    }

    public static void main(String[] args) {
        testFactory(new BicycleFactory());
        testFactory(new TricycleFactory());
        testFactory(new UnicycleFactory());
    }
}
