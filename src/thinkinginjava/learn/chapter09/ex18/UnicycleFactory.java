package thinkinginjava.learn.chapter09.ex18;

public class UnicycleFactory implements CycleFactory {

    @Override
    public Cycle getCycle() {
        return new Unicycle();
    }

}
