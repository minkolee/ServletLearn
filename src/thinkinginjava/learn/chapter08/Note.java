package thinkinginjava.learn.chapter08;

import thinkinginjava.learn.chapter06.exercise08.ConnectionManager;

public enum Note {
    MIDDLE_C,C_SHARP, B_FLAT;
}


class Jenny {
    private int age = 35;

    void setAge(int age) {
        this.age = age;
    }

    int getAge() {
        return age;
    }
}

class Cony extends Jenny {

    private int age = 5;

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    public int getMotherAge() {
        return super.getAge();
    }

    public static void main(String[] args) {
        Jenny jenny = new Jenny();
        jenny.setAge(50);
        System.out.println(jenny.getAge());


        Cony cony = new Cony();
        System.out.println(cony.getAge());

        //通过父类方法访问隐藏在自己对象中的父类的域
        System.out.println(cony.getMotherAge());
    }

}