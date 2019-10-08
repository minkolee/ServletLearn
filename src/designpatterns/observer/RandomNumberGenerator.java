package designpatterns.observer;


import java.util.Random;

public class RandomNumberGenerator extends NumberGenerator {

    private Random random = new Random();

    private int number;

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void execute() {
        number = random.nextInt(1000);
        notifyObserver();
    }
}
