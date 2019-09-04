package thinkinginjava.learn.chapter07;

public class Test1 {
    public static void main(String[] args) {
        Cleanser cleanser = new Cleanser();
        cleanser.dilute();
        cleanser.apply();
        cleanser.scrub();
        System.out.println(cleanser);
        Detergent detergent = new Detergent();
        detergent.scrub();
        System.out.println(detergent);
        System.out.println(detergent.getS());
    }
}

class Cleanser {
    private String s = "Cleaner";

    public void append(String s) {
        this.s += s;
    }

    public void dilute() {
        append(" dilute()");
    }

    public void apply() {
        append(" apply()");
    }

    public void scrub() {
        append(" scrub()");
    }

    @Override
    public String toString() {
        return s;
    }

    public String getS() {
        return s;
    }
}

class Detergent extends Cleanser {

    @Override
    public void scrub() {
        append(" Detegent.scrub()");
        super.scrub();
    }

    public void foam() {
        append(" foam()");
    }
}