package designpatterns.prototype;

public class UnderlinePen implements Product {

    private char decochar;

    public UnderlinePen(char decochar) {
        this.decochar = decochar;
    }

    //没有什么实际意义的use, 仅仅为了实现
    @Override
    public void use(String s) {
        int length = s.getBytes().length;
        System.out.println("\"" + s + "\"");
        System.out.print(" ");
        for (int i = 0; i < length; i++) {
            System.out.print(decochar);
        }
        System.out.println();
    }


//    @Override
//    public Product createClone() {
//        Product p = null;
//        try{
//            //clone()方法调用之后得到的是Object类型, 需要转型. 调用.clone()方法得到的是当前对象的复制
//            p = (Product) clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//        return p;
//    }
}
