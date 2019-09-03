package thinkinginjava.learn.chapter05;

public class Ex20 {

    private String name;

    private String age = "30";

    private String age2;

    public static void main(String... args) {
        Ex20 ex01 = new Ex20();

        Ex20 ex011 = new Ex20("saner");

        System.out.println(ex01.age2);
        System.out.println(ex011.age2);

    }

    Ex20() {
        age2 = "ini";
    }

    Ex20(String age) {
        this.age2 = age;
    }

}
