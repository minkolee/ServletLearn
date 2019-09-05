package thinkinginjava.learn.chapter09;

import ajaxlearn.Print;

public class Strategy {

    public static Object process(Processor processor, Object s) {
        return processor.process(s);
    }

    public static void main(String[] args) {
        System.out.println(process(new Splitter(), "Diablos"));
        System.out.println(process(new Upcase(), "bulubulu"));
        System.out.println(process(new Downcase(), "benglong"));
    }
}


