package designpatterns.prototype;

import java.util.ArrayList;
import java.util.List;

public class MessageBox implements Product {

    private char decochar;

    private List<Integer> list = new ArrayList<>();

    public void showList() {
        System.out.println(list);
    }

    public void put(int i) {
        list.add(i);
    }

    public MessageBox(char decochar) {
        this.decochar = decochar;
    }

    //没有什么实际意义的use, 仅仅为了实现
    @Override
    public void use(String s) {
        int length = s.getBytes().length;
        for (int i = 0; i < length + 4; i++) {
            System.out.print(decochar);
        }
        System.out.println();
        System.out.println(decochar + " " + s + " " + decochar);
        for (int i = 0; i < length + 4; i++) {
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
