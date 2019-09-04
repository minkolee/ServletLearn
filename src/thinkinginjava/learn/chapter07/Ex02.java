package thinkinginjava.learn.chapter07;

public class Ex02 extends Detergent {

    @Override
    public void scrub() {
        append(" Ex02.srcub()");
    }

    public void sterilize() {
        append(" ex02.sterilize");
    }

    public static void main(String[] args) {
        Ex02 ex02 = new Ex02();
        ex02.scrub();
        ex02.sterilize();
        System.out.println(ex02);
    }
}


