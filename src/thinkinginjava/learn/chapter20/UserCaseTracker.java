package thinkinginjava.learn.chapter20;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class UserCaseTracker {

    public static void trackUserCases(Class<?> cl) {
        //对于类的每个方法, 获取其中Test类型的注解
        for (Method m : cl.getDeclaredMethods()) {
            System.out.println(m.getName());
            Test uc = m.getAnnotation(Test.class);
            if (uc != null) {
                System.out.println(uc.id());
                System.out.println(uc.description());
            }
            System.out.println();

        }
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        trackUserCases(UserCase.class);
        UserCase userCase = new UserCase();
        userCase.getClass().getMethod("exe3", int.class).invoke(userCase, 6);

    }

}


class UserCase {

    @Test(id = 1, description = "first method")
    public void exe() {
        System.out.println("exed");
    }

    @Test(id = 2)
    public void exe2() {

    }

    @Test(id = 3, description = "third")
    public void exe3(int i) {
        System.out.println(i);
    }
}