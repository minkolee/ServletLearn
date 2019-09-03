package thinkinginjava.learn.chapter06.exercise06;

public class Son extends Father {


}

class Test {
    public static void main(String[] args) {
        Father father = new Father();
        Son son = new Son();
        father.show(10);
        son.show(11);

    }
}