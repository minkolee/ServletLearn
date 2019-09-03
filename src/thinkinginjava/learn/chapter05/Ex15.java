package thinkinginjava.learn.chapter05;

public class Ex15 {

    public static void main(String[] args) {
        System.out.println(TestClass2.a);
        System.out.println("-----------------");
        System.out.println(TestClass2.b);

        System.out.println("---------------------");

        TestClass2 testClass2 = new TestClass2("saner");

    }
}

class TestClass2 {
    public static String a = "定义初始化static字符串";
    public static String b;

    String c;

    static {
        System.out.println(a);
        System.out.println("准备初始化b");
        b = "在静态块中初始化";
    }

    {
        System.out.println("非静态块开始");
        c = "非静态中构造的字符串";
        System.out.println(c);
    }

    TestClass2(String s) {
        a = "构造器a";
        b = "构造器b";
        c = s;
        System.out.println(c);
    }


}