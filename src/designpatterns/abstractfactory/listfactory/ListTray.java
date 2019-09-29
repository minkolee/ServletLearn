package designpatterns.abstractfactory.listfactory;

import designpatterns.abstractfactory.factory.Item;
import designpatterns.abstractfactory.factory.Tray;


public class ListTray extends Tray {
    public ListTray(String caption) {
        super(caption);
    }

    //Tray的makeHTML()要注意, 内部的ArrayList中可能存放有List或者Tray对象, List对象我们已经编写完毕了.
    //Tray内部有Tray对象的话, 遍历然后调用makeHTML()方法, 这样即使嵌套, 也可以正确的自动递归来实现.
    //这里除了抽象工厂的方法之外, 可以看到, 对于嵌套的内容, 如果最深层都是同样的零件, 通过把最深层的零件和外壳零件声明为同一个类型, 然后编写方法, 可以自然而然的实现递归, 而不用人工去递归. 感觉这个思想比面向对象还重要.
    @Override
    public String makeHTML() {
        StringBuilder result = new StringBuilder();

        //先写入标题部分
        result.append("<li>\n")
                .append(caption)
                .append("\n")

                .append("<ul>\n");

        for (Item tray : this.trays) {
            result.append(tray.makeHTML());
        }

        result.append("</ul>\n").append("</li>\n");
        return result.toString();
    }
}
