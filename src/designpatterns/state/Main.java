package designpatterns.state;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        SafeFrame safeFrame = new SafeFrame("金库模式");
        while (true) {

            for (int hour = 0; hour < 24; hour++) {
                safeFrame.setClock(hour);
                Thread.sleep(500);
            }
        }
    }
}
