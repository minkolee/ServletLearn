package thinkinginjava.learn.chapter07;

import java.util.Random;

public class Ex09  {

    public static void main(String[] args) {
        Stem stem = new Stem();
        stem.getComponent3();
    }

}

class Root {

    Root() {
        System.out.println("Root constructor");
    }

    Component1 component1 = new Component1();
    Component2 component2 = new Component2();
    Component3 component3 = new Component3();

    public Component1 getComponent1() {
        return component1;
    }

    public Component2 getComponent2() {
        return component2;
    }


}


class Component1 {
    Component1() {
        System.out.println("Component1");
    }
}


class Component2 {
    Component2() {
        System.out.println("Component2");
    }
}


class Component3 {
    Component3() {
        System.out.println("Component3");
    }
}

class Stem extends Root {
    Stem() {
        System.out.println("Stem constructor");
    }

    public Component3 getComponent3() {
        return component3;
    }
}