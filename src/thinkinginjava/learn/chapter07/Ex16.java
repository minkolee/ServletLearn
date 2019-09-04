package thinkinginjava.learn.chapter07;

import javax.xml.namespace.QName;

public class Ex16 {

    public static void main(String[] args) {
        //向上转型, 实际上是重载, 根据了传入的类型判断使用了哪种方法
        Frog frog1 = new Frog("jenny");
        Frog frog2 = new Frog("cony");
        frog2.meet(frog1);

    }

}


class Amphibian {
    private String name;

    Amphibian() {
        this.name = "default";
    }

    Amphibian(String name) {
        this.name = name;
    }

    public void meet(Amphibian amphibian) {
        System.out.println("父类方法");
        System.out.println(name + " meets " + amphibian.name);
    }

    protected void setName(String s) {
        this.name = s;
    }

    protected String getName() {
        return name;
    }

}

class Frog extends Amphibian {
    Frog() {
        super();
    }

    Frog(String s) {
        setName(s);
    }

    public void meet(Frog s) {
        System.out.println("子类方法");
        System.out.println(this.getName() + " meets " + s.getName());
    }
}