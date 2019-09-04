package thinkinginjava.learn.chapter08.polymorphism.shape;

public class Shapes {

    //练习2 ,加上@Override 这是可以的, 因为多态就是要覆盖同一个父类的一个方法, 各个子类都有自己独特的方法才可以多态



    private static RandomShapeGenerator randomShapeGenerator = new RandomShapeGenerator();

    public static void main(String[] args) {
        Shape[] shapes = new Shape[20];

        for (int i = 0; i < shapes.length; i++) {
            shapes[i] = randomShapeGenerator.next();
        }

        for (Shape shape : shapes) {
            shape.draw();
            //练习3, 父类加一个方法, 子类不覆盖, 能实现多态吗?
            //答案是不行, 向上转型到Shape, 全是按照shape类型的调用
            shape.fatherMethod();
            //练习3 中的部分子类覆盖的方法
            shape.partiallyOver();
            //练习5
            System.out.println(shape.wheels());
            System.out.println("-----------------");
        }
    }

}
