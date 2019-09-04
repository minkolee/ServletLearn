package thinkinginjava.learn.chapter08.ex01;

public class Cycle {

    public void ride() {
        System.out.println("Normal ride");
    }

    public static void rideOnCycle(Cycle cycle) {
        cycle.ride();
    }

    public static void main(String[] args) {
        Unicyle unicyle = new Unicyle();
        Bicycle bicycle = new Bicycle();
        Tricycle tricycle = new Tricycle();

        rideOnCycle(unicyle);
        rideOnCycle(bicycle);
        rideOnCycle(tricycle);
    }

}

class Unicyle extends Cycle {

    public void ride() {
        System.out.println("Unicycle ride");

    }
}

class Bicycle extends Cycle {
    public void ride() {
        System.out.println("Bicycle ride");

    }
}

class Tricycle extends Cycle {
    public void ride() {
        System.out.println("Tricycle ride");
    }
}