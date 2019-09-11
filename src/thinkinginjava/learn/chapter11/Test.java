package thinkinginjava.learn.chapter11;

import thinkinginjava.sep05.A;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {


        ArrayList<Gerbil> arrayList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            arrayList.add(new Gerbil());
        }


        for (int i = 0; i < 10; i++) {
            arrayList.get(i).hop();
        }

    }
}
