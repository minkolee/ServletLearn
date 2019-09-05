package thinkinginjava.sep05;

public class B2 extends AP {

    private String s = "String in B2";

    public static void main(String[] args) {
        B2 b2 = new B2();
        System.out.println(b2.getS());
        b2.setS("New String set by B2");
        System.out.println(b2.getS());
        System.out.println("-----------------");
    }
}
