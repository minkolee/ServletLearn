package thinkinginjava.learn.chapter06.exercise05;

public class Ex05 {

    Ex05(String name, int i) {
        count = i;
        this.name = name;
    }

    public static int count2;

    private int count;
    public String name;

    protected void show() {
        System.out.println(name);
    }

    void tell() {
        System.out.println(count);
    }
}
