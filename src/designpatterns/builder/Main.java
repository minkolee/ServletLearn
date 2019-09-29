package designpatterns.builder;

public class Main {

    public static void main(String[] args) {
        String title = "设计模式";
        String string = "23种设计模式";
        String[] items = new String[]{"适配器模式", "建造者模式", "工厂模式", "迭代器模式", "原型模式", "单例模式", "模板模式"};

        HTMLBuilderTitleFirst htmlBuilder = new HTMLBuilderTitleFirst();
        new Director(htmlBuilder).construct(title, string, items);
        System.out.println(htmlBuilder.getFilename());



    }
}
