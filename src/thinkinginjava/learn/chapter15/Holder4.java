package thinkinginjava.learn.chapter15;

import thinkinginjava.sep05.A;

import java.util.ArrayList;
import java.util.Arrays;

public class Holder4<T> {

    private T a,b,c;

    private Holder4(T a) {
        this.a = a;
    }

    private Holder4(T a, T b, T c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public ArrayList<T> getAll() {
        ArrayList<T> arrayList = new ArrayList<>();
        arrayList.add(a);
        arrayList.add(b);
        arrayList.add(c);
        return arrayList;
    }

    public T get1() {
        return a;
    }

    public T get2() {
        return b;
    }

    public T get3() {
        return c;
    }

    public static void main(String[] args) {
        //练习1, 如果可以持有基类, 则也可以持有导出类型

        Father father1 = new Father();
        Father father2 = new Father();
        Father father3 = new Father();

        Holder4<Father> fatherHolder4 = new Holder4<>(father1, father2, father3);

        for (Father father : fatherHolder4.getAll()) {
            System.out.println(father);
        }

    }
}
