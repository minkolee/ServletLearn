package thinkinginjava.learn.chapter11;


import java.util.ArrayList;

public class SimpleCollection {

    public static void main(String[] args) {
        ArrayList<Integer> c = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            c.add(i);
        }

        for (Integer i : c) {
            System.out.println(i);
        }

        c.set(1, 9);
        for (Integer i : c) {
            System.out.println(i);
        }

    }

}
