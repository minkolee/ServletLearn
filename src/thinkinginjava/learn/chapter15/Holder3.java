package thinkinginjava.learn.chapter15;

import thinkinginjava.learn.chapter14.ToyTest;

public class Holder3<T> {

    private T a;

    private Holder3(T a) {
        this.a = a;
    }

    public T get() {
        return a;
    }

    public static void main(String[] args) {
        //练习1, 如果可以持有基类, 则也可以持有导出类型

        Holder3<Father> holder3 = new Holder3<>(new Father());

        System.out.println(holder3.get());

        Holder3<Father> holder4 = new Holder3<>(new Son());

        System.out.println(holder4.get());

    }
}


class Father {

}

class Son extends Father {

}