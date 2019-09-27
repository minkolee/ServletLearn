package designpatterns.factorymethod;

public class IDCard extends Product {

    //加一个静态变量用于统计数量
    private static int serial = 0;

    private int number;

    private String owner;

    IDCard(String owner) {
        this(owner, getNumber());
    }

    //新增一个构造器, 为了不破坏框架
    IDCard(String owner, int number) {
        System.out.println("制作" + owner + "的身份证, 编号是: " + number);
        this.owner = owner;
        this.number = number;
    }

    @Override
    public void use() {
        System.out.println("使用" + this);
    }

    @Override
    public String toString() {
        return "IDCard{" +
                "number=" + number +
                ", owner='" + owner + '\'' +
                '}';
    }

    //加上同步
    private synchronized static int getNumber() {
        return serial++;
    }

    //添加上两个Get方法
    @Override
    public int getSerial() {
        return number;
    }

    @Override
    public String getOwner() {
        return owner;
    }
}
