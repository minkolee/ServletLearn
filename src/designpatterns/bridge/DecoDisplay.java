package designpatterns.bridge;

import java.io.IOException;

public class DecoDisplay extends Display {


    public DecoDisplay(DisplayImpl impl) {
        super(impl);
    }

    public void decoDisplay(int times, int multi) throws IOException {
        if (times < 0 || multi <= 0) {
            throw new RuntimeException("times大于等于0, multi大于0");
        }

        for (int i = 0; i < times; i++) {
            open();
            for (int j = 0; j < multi * i; j++) {
                print();
            }
            close();
        }
    }

}
