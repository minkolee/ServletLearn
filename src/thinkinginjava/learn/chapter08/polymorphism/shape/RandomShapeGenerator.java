package thinkinginjava.learn.chapter08.polymorphism.shape;

import java.util.Random;

public class RandomShapeGenerator {
    private Random random = new Random();

    public Shape next() {
        switch (random.nextInt(4)) {
            default:
            case 0:
                return new Circle();
            case 1:
                return new Square();
            case 2:
                return new Triangle();
            case 3:
                return new Star();
        }
    }
}
