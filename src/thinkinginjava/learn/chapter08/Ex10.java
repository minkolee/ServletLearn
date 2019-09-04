package thinkinginjava.learn.chapter08;

import javax.persistence.Version;

public class Ex10 {


    public static void main(String[] args) {
        //向上转型之后, 调用的是父类的方法, 但是父类调用子类的方法, 还是多态绑定, 所以依然是子类
        Base subBase = new SubBase();
        subBase.print();
    }

}


class Base {

    public void print() {
        System.out.println("Base的print1");
        print2();
    }

    public void print2() {
        System.out.println("Base类中的print2");
    }
}


class SubBase extends Base {

    @Override
    public void print() {
        System.out.println("子类的print1");

        print2();
    }

    @Override
    public void print2() {
        System.out.println("Sub类中覆盖的print2方法");
    }

}