package designpatterns.bridge;

import designpatterns.builder.TextBuilder;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        //创建实现类对象, 这里创建的要点是, 根据功能层次选择对应的类型, 传入的参数则是实现层次的对象.

        //创建一个实现层次的对象
        DisplayImpl textDisplay = new TextFileDisplayImpl("test.html");

        //要使用普通显示功能, 即Display类
//        Display display = new Display(stringDisplay);
//        display.display();

        //要使用重复显示功能, 即CountDisplay类
//        CountDisplay countDisplay = new CountDisplay(stringDisplay);
//        countDisplay.multiDisplay(10);


        Display display = new Display(textDisplay);
        display.display();
    }
}
