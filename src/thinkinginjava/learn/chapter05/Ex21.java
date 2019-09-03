package thinkinginjava.learn.chapter05;

import java.util.Arrays;

import static ajaxlearn.Print.*;

public class Ex21 {

    public static void main(String[] args) {
        printArray(args);
        println(RMB.valueOf("TWO"));
        RMB rmb;
        rmb = RMB.HUNDRED;
        println(rmb);

        switch (rmb) {
            case ONE:
                System.out.println("ONE");
                break;
            case TWO:
                System.out.println("2");
                break;
            case TEN:
                System.out.println("10");
                break;
            case TWENTY:
                System.out.println("20");
                break;
            case HUNDRED:
                System.out.println("100");
                break;
            default:
                System.out.println("NOTHING");

        }
    }
}

enum RMB {
    /**
     *
     */
    ONE,TWO,FIVE,TEN,TWENTY, HUNDRED,
}
