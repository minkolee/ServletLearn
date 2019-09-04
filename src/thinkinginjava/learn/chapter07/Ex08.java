package thinkinginjava.learn.chapter07;

public class Ex08 {

    public static void main(String[] args) {
        Ex ex = new Ex();
    }
}

class Base {
    Base(int i) {
        System.out.println("Base contructor " + i);
    }
}

class Ex extends Base {
    Ex() {
        super(1);
    }

    Ex(int i) {
        super(i);
    }
}