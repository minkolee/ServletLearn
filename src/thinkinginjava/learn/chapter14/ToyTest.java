package thinkinginjava.learn.chapter14;

import java.util.HashMap;

/**
 * 练习1里, 去掉默认构造器, 就无法通过.newInstance方法创建Toy对象.
 */

public class ToyTest {

    static void printInfo(Class cc) {
        System.out.println("Class name: " + cc.getSimpleName());
        System.out.println("Is interface: " + cc.isInterface());
        System.out.println("Full name: " + cc.getName());
        System.out.println("Canoncial name: " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = FancyToy.class;
        } catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }

        printInfo(c);

        for (Class aInterface : c.getInterfaces()) {
            System.out.println(aInterface);

        }

        //查询直接基类
        Class up = c.getSuperclass();
        Object object = null;

        try {
            //反射用这个方法创建对象已经被删除了
            object = up.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            System.out.println("无法初始化");
            System.exit(1);
        }

        printInfo(object.getClass());

    }

}

interface HasBatteries {

}

interface WaterProof {

}

interface Shoots {

}

interface NewInterface {

}

class Toy {
//    Toy() {}

    Toy(int i) {

    }
}

class FancyToy extends Toy implements HasBatteries, WaterProof, Shoots, NewInterface {
    FancyToy() {
        super(1);
    }
}