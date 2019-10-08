package designpatterns.observer;

public class DigitObserver implements Observer {

    @Override
    public void update(NumberGenerator generator) {
        System.out.println("接收到被观察者的的通知, 数值是: " + generator.getNumber());
    }
}
