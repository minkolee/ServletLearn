package thinkinginjava.learn.chapter03;

import static java.lang.System.out;

class Saner {
    float feather;
}



public class Ex02 {

    private void changeFeather(Saner saner) {
        saner.feather = 33;
    }

    public static void main(String[] args) {
        //基本类型赋值是复制



        Saner s1 = new Saner();
        Saner s2 = new Saner();

        s1.feather = 99;
        s2.feather = 30;
        out.println("S1的羽毛有: " + s1.feather + "根");
        out.println("S2的羽毛有: " + s1.feather + "根");

        //对象复制就是指针复制, 指向同一个对象
        s1 = s2;
        s1.feather = 88;
        s2.feather = 100;

        out.println("S1的羽毛有: " + s1.feather + "根");
        out.println("S2的羽毛有: " + s1.feather + "根");

        //传递对象进来传的也是引用, 其实就是指针啦
        Ex02 ex02 = new Ex02();
        ex02.changeFeather(s1);

        out.println("S1的羽毛有: " + s1.feather + "根");
        out.println("S2的羽毛有: " + s1.feather + "根");
    }


}
