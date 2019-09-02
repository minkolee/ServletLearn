package thinkinginjava.learn.chapter05;

public class Ex01 {

    private String name;

    private String age = "30";

    private String age2;

    public static void main(String[] args) {
        Ex01 ex01 = new Ex01();

        Ex01 ex011 = new Ex01("saner");

        System.out.println(ex01.age2);
        System.out.println(ex011.age2);

    }

    Ex01() {
        age2 = "ini";
    }

    Ex01(String age) {
        this.age2 = age;
    }

}
