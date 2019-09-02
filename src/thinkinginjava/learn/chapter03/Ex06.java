package thinkinginjava.learn.chapter03;

import static java.lang.System.out;

public class Ex06 {

    public static void main(String[] args) {

        Dog spot = new Dog();
        spot.name = "spot";
        Dog scruffy = new Dog();
        scruffy.name = "scruffy";
        spot.says = "Ruff!";
        scruffy.says = "Wurf!";

        Dog spot2 = new Dog();
        spot2.name = "spot";

        //重写了Equals方法, 如果两条狗名字相同就返回相同
        //这一行测试指针, 所以不相同
        out.println(spot == spot2);
        //这一行使用equals方法, 所以相等
        out.println(spot.equals(spot2));

    }

}

