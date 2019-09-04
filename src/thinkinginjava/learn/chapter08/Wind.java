package thinkinginjava.learn.chapter08;

public class Wind extends Instrument {


    public void play(Note note) {
        System.out.println("Wind.play()");

    }

    public int getI() {
        return i;
    }
}


class Instrument {

    int i = 88;

    public void play(Note note) {
        System.out.println("Instrument.play()");

    }

    public int getI() {
        return this.i;
    }
}
