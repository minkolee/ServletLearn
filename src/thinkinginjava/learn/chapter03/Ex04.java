package thinkinginjava.learn.chapter03;

public class Ex04 {


    public static void main(String[] args) {
        Speed speed = new Speed(100, 30);
        System.out.println(speed.getSpeed());

    }
}


class Speed {

    private double speed;

    Speed(double distance, double time) {
        this.speed = distance / time;
    }

    public double getSpeed() {
        return speed;
    }
}
