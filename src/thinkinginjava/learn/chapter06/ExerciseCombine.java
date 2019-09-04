package thinkinginjava.learn.chapter06;

import thinkinginjava.learn.chapter06.exercise04.Test;
import thinkinginjava.learn.chapter06.exercise05.Ex05;
import thinkinginjava.learn.chapter06.exercise06.Father;
import thinkinginjava.learn.chapter06.exercise06.Son;
import thinkinginjava.learn.chapter06.exercise08.ConnectionManager;

public class ExerciseCombine {

    public static void main(String[] args) {
        //练习04, 调用不是同一个包里的 protected方法
        //发现无法调用
        //包里可以调用, 说明protected 不是 public
        Test test = new Test();

        //练习05
//        构造器是包里的,没法访问
//        Ex05 ex05 = new Ex05();
        // public类其中的public static变量, 可以
        Ex05.count2 = 3;

        //练习06
        Father father = new Father();
        Son son = new Son();
        //包外不能使用protected方法
//        father.show();
    }


}
