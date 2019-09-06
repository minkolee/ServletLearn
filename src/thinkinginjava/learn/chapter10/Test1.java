package thinkinginjava.learn.chapter10;

public class Test1 {

    public static void main(String[] args) {
        //两个内部类的对象都有指向同一个对象的指针, 非静态内部类不能脱离外部对象存在
        Outer outer = new Outer();

        Outer.Inner inner = outer.new Inner();

        outer.setName("saner");

        Outer.Inner inner2 = outer.new Inner();

        System.out.println(inner.show());
        System.out.println(inner2.show());
        Outer outer2 = new Outer();
        outer2.setName("owl");
        Outer.Inner inner3 = outer2.new Inner();
        System.out.println(inner3.show());

    }

}

class Outer {

    private String name = "gugug";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    class Inner {
        String show() {
            return name;
        }
    }


}
