package thinkinginjava.learn.chapter05;

public class Ex03 {

    public static void main(String[] args) {
        Dem dem = new Dem("spot");
    }
}


class Dem {
    Dem() {
        System.out.println("Dem default");
    }

    Dem(String name) {
        this();
        System.out.println(name);

    }
}