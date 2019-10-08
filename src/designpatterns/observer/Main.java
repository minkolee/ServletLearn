package designpatterns.observer;

public class Main {
    public static void main(String[] args) {
        //创建一个被观察者和两个观察者
        DigitObserver digitObserver = new DigitObserver();
        GraphObserver graphObserver = new GraphObserver();
        IncrementNumberGenerator incrementNumberGenerator = new IncrementNumberGenerator(10, 5, 50);

        incrementNumberGenerator.addObserver(digitObserver);
        incrementNumberGenerator.addObserver(graphObserver);

        incrementNumberGenerator.execute();
        incrementNumberGenerator.execute();
        incrementNumberGenerator.execute();
        incrementNumberGenerator.execute();
        incrementNumberGenerator.execute();
        incrementNumberGenerator.execute();
        incrementNumberGenerator.execute();
        incrementNumberGenerator.execute();
        incrementNumberGenerator.execute();
        incrementNumberGenerator.execute();
        incrementNumberGenerator.execute();


    }
}
