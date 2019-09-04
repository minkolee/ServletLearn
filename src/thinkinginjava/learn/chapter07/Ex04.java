package thinkinginjava.learn.chapter07;

public class Ex04 {

    public static void main(String[] args) {
        //父类构造器在子类之前调用
        Sa1 sa1 = new Sa1();
    }
}

class Fa1 {
    Fa1() {
        System.out.println("父类构造器");
    }
}

class Sa1 extends Fa1{
    Sa1() {
        System.out.println("子类构造器");
    }
}