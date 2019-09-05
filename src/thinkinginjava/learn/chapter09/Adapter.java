package thinkinginjava.learn.chapter09;

public class Adapter {
    //接受一个接口类
    private Processor processor;

    //构造器接受一个接口实现对象, 这样适配器里就持有了这个对象
    public Adapter(Processor processor) {

        this.processor = processor;
    }

    public String name() {
        return processor.name();
    }

    public Object process(Object input) {
        return processor.process(input);
    }

}
