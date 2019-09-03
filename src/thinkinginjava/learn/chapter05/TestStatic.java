package thinkinginjava.learn.chapter05;

public class TestStatic {

    public static void main(String[] args) {
        System.out.println("Creating new Cupboard() in main:");
        new Cupboard();
        //先加载类, 然后初始化静态部分
        //按顺序先创建 一个bowl4对象, 然后是bowl5对象
        //静态部分结束
        //非静态部分非配空间并清零, 也就是bowl3 =null
        //开始初始化非静态部分, 创建3号Bowl对象
        //已经依次打印了Bowl(4),Bowl(5),Bowl(3)
        //之后是构造器
        System.out.println("--------------");

        new Cupboard();
        //再次创建新橱柜对象, 静态部分 Bowl(4),Bowl(5)没有再初始化

        System.out.println("--------------");
        new Table();

    }
}


class Bowl {
    Bowl(int marker) {
        System.out.println("Bowl(" + marker + ")");
    }

    void f1(int marker) {
        System.out.println("f1(" + marker + ")");
    }
}

class Table {
    static Bowl bowl = new Bowl(1);

    Table() {
        System.out.println("Table()");
        bowl2.f1(1);
    }

    void f2(int marker) {
        System.out.println("f2(" + marker + ")");
    }

    static Bowl bowl2 = new Bowl(2);
}

class Cupboard {
    Bowl bowl3 = new Bowl(3);
    static Bowl bowl4 = new Bowl(4);

    Cupboard() {
        System.out.println("Cupboard()");
        bowl4.f1(2);

    }

    void f3(int marker) {
        System.out.println("f3(" + marker + ")");
    }

    static Bowl bowl5 = new Bowl(5);

}