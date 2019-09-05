package thinkinginjava.sep05;

public class B5 extends A {

    String s = "String in B5";

    @Override
    public String getS() {
        return s;
    }

    @Override
    public void setS(String s) {
        this.s = s;
    }

    public String getAS() {
        return super.getS();
    }

    public void setAS(String s) {
        super.setS(s);
    }

    public static void main(String[] args) {
        B5 b5 = new B5();
        System.out.println(b5.getS());
        System.out.println(b5.getAS());

        b5.setS("New String set by B5");
        b5.setAS("New String set by B5 to A");
        System.out.println(b5.getS());
        System.out.println(b5.getAS());
    }
}
