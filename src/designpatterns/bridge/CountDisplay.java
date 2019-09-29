package designpatterns.bridge;

import java.io.IOException;

public class CountDisplay extends Display {

    //这里调用父类构造器, 同样传入一个DisplayImpl对象
    public CountDisplay(DisplayImpl impl) {
        super(impl);
    }

    public void multiDisplay(int times) throws IOException {
        open();
        for (int i = 0; i < times; i++) {
            print();
        }
        close();
    }
}
