package thinkinginjava.learn.chapter07;

public class Ex13 {


    public static void main(String[] args) {
        BB bb = new BB();
        bb.show(3.2);
        bb.show(1);
        bb.show(1, 32.3);
        bb.show(10, "FD", 98.32);
    }
}


class AA {

    void show(int i, String s, double d) {
        System.out.println(i + s + d);
    }

    void show(int i, double d) {
        System.out.println(i + d);
    }

    void show(int i) {
        System.out.println(i);
    }
}

class BB extends AA {

    void show(double d) {
        System.out.println(d);
    }
}