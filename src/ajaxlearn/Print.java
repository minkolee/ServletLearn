package ajaxlearn;


import java.util.Arrays;

public class Print {

    public static void print(Object obj) {
        System.out.print(obj);
    }

    public static void println(Object obj) {
        System.out.println(obj);
    }

    public static void println() {
        System.out.println();
    }

    public static void printArray(Object[] obj) {
        println(Arrays.toString(obj));
    }
}
