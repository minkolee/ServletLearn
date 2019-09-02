package thinkinginjava.learn.chapter05;

public class Ex05 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.bark(10);
        dog.bark("wangwang");
        dog.bark(10.0);
        dog.bark("gugu",10);
        dog.bark(10, "saner");
    }
}


class Dog {

    public void bark(String bak) {
        System.out.println(bak);
    }

    public void bark(int i) {
        System.out.println("barked for " + i + " times");
    }

    public void bark(double i) {
        System.out.println("howling");
    }

    public void bark(String bak, int i) {
        System.out.println("bak for " + i + " times");
    }

    public void bark(int i, String bak) {
        System.out.println("has bak of " + i + " times");
    }

}