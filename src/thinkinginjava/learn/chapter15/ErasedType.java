package thinkinginjava.learn.chapter15;

import java.util.ArrayList;

public class ErasedType {

    public static void main(String[] args) {
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c2 == c1);

    }
}
