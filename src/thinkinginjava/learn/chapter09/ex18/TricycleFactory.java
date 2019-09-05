package thinkinginjava.learn.chapter09.ex18;

public class TricycleFactory implements CycleFactory {

    @Override
    public Cycle getCycle() {
        return new Tricycle();
    }

}
