package designpatterns.singleton;

public class SingleTon {

    private SingleTon() {
        System.out.println("创建了一个单例的实例");
    }

    private static SingleTon singleTon = new SingleTon();

    public static SingleTon getInstance() {
        return singleTon;
    }
}
