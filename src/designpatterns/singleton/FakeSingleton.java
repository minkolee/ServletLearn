package designpatterns.singleton;

public class FakeSingleton {

    private static FakeSingleton singleton = null;

    private FakeSingleton() {
        System.out.println("创建一个实例");
    }

    public static FakeSingleton getInstance() {
        if (singleton == null) {
            singleton = new FakeSingleton();
        }
        return singleton;
    }
}
