package thinkinginjava.learn.chapter05;

public class Ex14 {

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
    }
}

class TestClass {
    public static String a = "定义初始化static字符串";
    public static String b;

    static {
        System.out.println(a);
        System.out.println("准备初始化b");
        b = "在静态块中初始化";
    }

}