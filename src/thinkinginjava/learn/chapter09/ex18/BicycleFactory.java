package thinkinginjava.learn.chapter09.ex18;

public class BicycleFactory implements CycleFactory {

    @Override
    public Cycle getCycle() {
        return new Bicycle();
    }

}
