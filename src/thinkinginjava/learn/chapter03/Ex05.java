package thinkinginjava.learn.chapter03;

import static java.lang.System.out;

public class Ex05 {

    public static void main(String[] args) {

        Dog spot = new Dog();
        spot.name = "spot";
        Dog scruffy = new Dog();
        scruffy.name = "scruffy";
        spot.says = "Ruff!";
        scruffy.says = "Wurf!";

        out.println(spot.name + " barks " + spot.says);
        out.println(scruffy.name + " barks " + scruffy.says);
    }

}

class Dog {
    String name;
    String says;

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != Dog.class) {
            return false;
        }

        Dog temp = (Dog) obj;
        return temp.name.equals(name);
    }
}