package designpatterns.bridge;

import java.io.IOException;
import java.util.Random;

public class RandomDisplay extends Display {

    private static Random random = new Random();

    public RandomDisplay(DisplayImpl impl) {
        super(impl);
    }

    public void randomDisplay(int times) throws IOException {
        open();
        for (int i = 0; i < (random.nextInt(times)); i++) {
            print();
        }
        close();
    }
}
