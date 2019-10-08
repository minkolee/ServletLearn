package designpatterns.observer;

public class GraphObserver implements Observer {

    @Override
    public void update(NumberGenerator generator) {
        System.out.println("****" + generator.getNumber() + "****");
    }
}
