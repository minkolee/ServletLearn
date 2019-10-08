package designpatterns.observer;

public class IncrementNumberGenerator extends NumberGenerator {

    private int start;
    private int step;
    private int end;
    private int count = 0;
    private int currentNumber = 0;

    public IncrementNumberGenerator(int start, int step, int end) {
        this.start = start;
        this.step = step;
        this.end = end;
    }

    @Override
    public int getNumber() {
        return currentNumber;
    }

    @Override
    public void execute() {
        if (count == 0) {
            currentNumber = start;
        } else {
            if (currentNumber + step < end) {
                currentNumber += step;
            }
        }
        count++;
        notifyObserver();
    }
}
