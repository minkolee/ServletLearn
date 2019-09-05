package thinkinginjava.learn.chapter10;

public class Parcell {

    String parcellCompany = "MASIK";

    class Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    class Destination {
        private String label;

        Destination(String whereTo) {
            label = whereTo;
        }

        String readLabel() {
            return label;
        }

        String readCompany() {
            return parcellCompany;
        }
    }

    public void ship(String dest) {
        Contents c = new Contents();
        Destination d = new Destination(dest);
        System.out.println(d.readLabel());

    }

    public Destination to(String s) {
        return new Destination(s);
    }

    public Contents contents() {
        return new Contents();
    }

    public static void main(String[] args) {
        Parcell p = new Parcell();
        System.out.println(p);
        p.ship("Tasmania");
        Parcell.Destination destination = p.to("Google");
        System.out.println(destination.readLabel());
        System.out.println(p.to("A").readCompany());
        System.out.println(p.to("B").readCompany());
        System.out.println(p);
    }

}
