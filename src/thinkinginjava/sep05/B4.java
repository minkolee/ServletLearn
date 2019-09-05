package thinkinginjava.sep05;

public class B4 extends A {

    String s = "String in B4";

    @Override
    public String getS() {
        return s;
    }

    @Override
    public void setS(String s) {
        this.s = s;
    }

    public static void main(String[] args) {
        B4 b4 = new B4();
        System.out.println(b4.getS());
        b4.setS("New String set by B4");
        System.out.println(b4.getS());
    }
}
