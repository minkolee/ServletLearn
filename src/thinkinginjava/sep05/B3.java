package thinkinginjava.sep05;

public class B3 extends AP {

    private String s = "String in B3";

    @Override
    public String getS() {
        return s;
    }

    public static void main(String[] args) {
        B3 b3 = new B3();
        System.out.println(b3.getS());

        b3.setS("New String set by B3");
        System.out.println(b3.getS());
        System.out.println("-----------------");
    }
}
