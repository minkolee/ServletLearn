package thinkinginjava.learn.chapter07;

public class Ex21  {

}


class FF {

    private int ge;

    FF() {

    }

    FF(int i) {
        this.ge = i;
    }

    public final void showGe() {
        System.out.println(this.ge);
    }
}

class FF8 extends FF {

    private FF8(int i) {
        super(i);
    }

    public FF8() {
        this.ge = 8;
    }

    private int ge;

    //无法覆盖, 也不能比父类的权限更弱
//    public final void showGe() {
////        System.out.println(this.ge);
////    }
}