package thinkinginjava.learn.chapter15;

import java.util.HashMap;

public class EraseTest<T extends HashF> {

    private T obj;

    EraseTest(T t) {
        this.obj = t;
    }

    public void ff() {
        obj.f();
    }

    public static void main(String[] args) {
        HashF hashF = new HashF();

        EraseTest<HashF> eraseTest = new EraseTest<>(hashF);

        eraseTest.ff();

    }

}


class HashF {
    public void f() {
        System.out.println("HashF.f()");
    }
}