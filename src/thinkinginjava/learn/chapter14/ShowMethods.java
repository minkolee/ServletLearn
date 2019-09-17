package thinkinginjava.learn.chapter14;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class ShowMethods {

    private static String usage = "usage:\n" + "Showmethods qualified class.name\n" + "To show all methods in class or:\n";

    private static Pattern p = Pattern.compile("\\w+\\.");

    public static void main(String[] args) throws ClassNotFoundException {

        int lines = 0;

        try {
            Class<?> c = Class.forName("thinkinginjava.learn.chapter14.Toy");
            Method[] methods = c.getMethods();
            Constructor[] constructors = c.getConstructors();
            for (Method method : methods) {
                System.out.println(p.matcher(method.toString()).replaceAll(""));
            }
            System.out.println("---------------------------");
            for (Constructor constructor : constructors) {
                System.out.println(p.matcher(constructor.toString()).replaceAll(""));
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
}
