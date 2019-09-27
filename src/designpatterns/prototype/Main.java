package designpatterns.prototype;

public class Main {

    public static void main(String[] args) {
        //创建出所需对象
        Manager manager = new Manager();
        UnderlinePen upen = new UnderlinePen('~');
        MessageBox mbox = new MessageBox('*');
        MessageBox sbox = new MessageBox('/');

        //注册到manager对象中
        manager.register("strong", upen);
        manager.register("warning", mbox);
        manager.register("slash", sbox);
//
//        //根据strong名称创建对象, 得到的是什么呢, 是upen吗?
//        Product p1 = manager.create("strong");
//        System.out.println(p1);
//        System.out.println(upen);
//        System.out.println(p1 == upen);
//        //行为一样吗?
//        p1.use("saner");
//        upen.use("saner");
//
//        Product p2 = manager.create("warning");
//        p2.use("owl");
//
//        Product p3 = manager.create("slash");
//        p2.use("sixtuan");
//

        //测试浅复制, 都复制自同一个具体原型
        Product messagebox1 = manager.create("warning");
        Product messagebox2 = manager.create("warning");

        mbox.put(10);
        mbox.showList();
        ((MessageBox) messagebox1).showList();
        ((MessageBox) messagebox2).showList();
        ((MessageBox) messagebox2).put(20);
        mbox.showList();
        ((MessageBox) messagebox1).showList();
        ((MessageBox) messagebox2).showList();

    }
}
