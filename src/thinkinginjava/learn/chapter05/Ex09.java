package thinkinginjava.learn.chapter05;

public class Ex09 {

    public static void main(String[] args) {
        Lance lance = new Lance("canvua", 100);
        System.out.println(lance);

    }
}

class Lance {
    private String name;
    private int attack;

    Lance(String name) {
        this.name = name;
    }

    Lance(String name, int attack) {
        this(name);
        this.attack = attack;
    }

    @Override
    public String toString() {
        return "Lance{" +
                "name='" + name + '\'' +
                ", attack=" + attack +
                '}';
    }
}