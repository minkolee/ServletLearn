package thinkinginjava.learn.chapter11;

public class Gerbil {

    private static int count = 0;

    private int number;

    Gerbil() {
        this.number = count++;
    }

    public int hop() {
        System.out.println("Gerbil "+ this.number +" is jumping.");
        return this.number;
    }


}
