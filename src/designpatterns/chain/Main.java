package designpatterns.chain;

public class Main {

    public static void main(String[] args) {
        //创建各种解决问题的对象
        Support a = new NoSupport("a");
        Support b = new LimitSupport("b", 3);
        Support c = new SpecialSupport("c", 5);
        Support d = new OddSupport("d");
        Support e = new SpecialSupport("e", 8);

        //串成一个链, 注意我们的方法里返回next, 很巧妙
        a.setNext(b).setNext(c).setNext(d).setNext(e);

        //然后来解决问题
        for (int i = 0; i < 10; i++) {

            a.support(new Trouble(i));
        }
    }
}
