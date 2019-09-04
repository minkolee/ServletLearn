package thinkinginjava.learn.chapter08;

import javax.persistence.criteria.CriteriaBuilder;

public class Music {

    public static void tune(Instrument instrument) {
        //由于是Instrument的静态域, 所以就返回静态域
        System.out.println(instrument.getI());
        instrument.play(Note.MIDDLE_C);
    }

    public static void main(String[] args) {
        Wind flute = new Wind();
        System.out.println(flute.i);
//        tune(flute);
        Instrument n = new Instrument();
        System.out.println(n.i);
//        tune(n);

        System.out.println(flute.getI());
        System.out.println(n.getI());

    }
}
