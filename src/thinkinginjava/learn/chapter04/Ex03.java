package thinkinginjava.learn.chapter04;

import java.util.Random;

public class Ex03 {

    public static void main(String[] args) throws InterruptedException {

        Random random = new Random();

        int count = 0;

        int first = 0;

        int last = 0;

        while (true) {
            first = last;
            last = random.nextInt(100);
            count++;
            if (count == 1) {
                continue;
            }
            if (first > last) {
                System.out.println(count-1 + " " + first + "大于" + last);
            } else if (first == last) {
                System.out.println(count-1 + " " + first + "等于" + last);
            } else  {
                System.out.println(count-1 + " " + first + "小于" + last);
            }
            Thread.sleep(1000);
        }
    }
}
