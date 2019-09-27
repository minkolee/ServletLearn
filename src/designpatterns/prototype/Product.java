package designpatterns.prototype;

public interface Product extends Cloneable {

    void use(String s);

    default Product createClone() {
        Product p = null;
        try {
            //clone()方法调用之后得到的是Object类型, 需要转型. 调用.clone()方法得到的是当前对象的复制
            p = (Product) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
