package designpatterns.observer;

import java.util.ArrayList;

public abstract class NumberGenerator {

    private ArrayList<Observer> observers = new ArrayList<>();

    //注册新的观察者
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }
    //去除观察者
    public void deleteObserver(Observer observer) {
        this.observers.remove(observer);
    }

    //通知观察者
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    public abstract int getNumber();

    public abstract void execute();
}
