package thinkinginjava.learn.chapter08;

public class P163 {

    public static void main(String[] args) {
        //记住凡是动态绑定, 一定是调用导出类的方法
        //这里会调用父类构造器, 父类构造器里调用draw(),也不是父类的, 因为压根没有父类对象, 所以依然是调子类的draw方法
        //但是父类构造器运行的时候, 只用匿名页面初始化了类变量, 所以等于0
        new RoundGlyph(5);
    }
}

class Glyph {
    void draw() {
        System.out.println("Glyph draw()");

    }

    Glyph() {
        System.out.println("Before draw()");
        draw();
        System.out.println("After draw()");
    }
}

class RoundGlyph extends Glyph {
    private int radius = 1;

    RoundGlyph(int radius) {
        this.radius = radius;
        System.out.println("RoundGlyph  radius = " + radius);

    }

    @Override
    void draw() {
        System.out.println("RoundGlyph draw() radius=" + radius);

    }
}