package thinkinginjava.learn.chapter07;

public class Ex03 {

    public static void main(String[] args) {
        //隐含构造器 ,调用父类构造器
        Sa sa = new Sa();
    }
}

class Fa {
    Fa() {
        System.out.println("父类构造器");
    }
}

class Sa extends Fa {

}