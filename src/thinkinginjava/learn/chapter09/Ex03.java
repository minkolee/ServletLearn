package thinkinginjava.learn.chapter09;

import thinkinginjava.sep05.A;

public class Ex03 {


    //和之前例子很像, 基类构造器启动的时候, 子类的变量还全部都是0
    //等基类初始化完毕了, 才回到子类的设置域上来, 此时才有正常值10
    public static void main(String[] args) {
        ABS03s abs03s = new ABS03s();
        abs03s.print();
    }

}

abstract class ABS03 {

    ABS03() {
        print();
    }

    abstract void print();
}

class ABS03s extends ABS03 {

    private int i = 10;

    @Override
    void print() {
        System.out.println(i);
    }
}
