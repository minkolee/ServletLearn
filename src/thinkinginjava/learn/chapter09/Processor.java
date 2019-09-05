package thinkinginjava.learn.chapter09;

public interface Processor {

    String name();

    Object process(Object input);
}

class Upcase implements Processor {

    @Override
    public String name() {
        return "Upcase";
    }

    @Override
    public Object process(Object input) {
        System.out.println("Upcase processing");
        return ((String)input).toLowerCase();
    }
}

class Downcase implements Processor {

    @Override
    public String name() {
        return "Downcase";
    }

    @Override
    public Object process(Object input) {
        System.out.println("Downcase processing");
        return ((String)input).toLowerCase();
    }
}

class Splitter implements Processor {

    @Override
    public String name() {
        return "Splitter";
    }

    @Override
    public Object process(Object input) {
        System.out.println("Splitter processing");
        return ((String)input).toLowerCase();
    }
}