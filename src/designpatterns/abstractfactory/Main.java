package designpatterns.abstractfactory;

import designpatterns.abstractfactory.factory.*;
import designpatterns.abstractfactory.listfactory.ListLink;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class Main {

    public static void main(String[] args) throws IOException {
        //反射获取类对象
        Factory listFactory = Factory.getFactory("designpatterns.abstractfactory.listfactory.ListFactory");

        //开始组装内容
        Link link1=  listFactory.createLink("柚子小站", "http://conyli.cc");
        Link link2=  listFactory.createLink("柚子小站2", "http://conyli.cc");
        Link link3=  listFactory.createLink("柚子小站3", "http://conyli.cc");
        Link link4=  listFactory.createLink("柚子小站4", "http://conyli.cc");

        Tray tray1 = listFactory.createTray("柚子小站列表1");
        tray1.add(link2);
        tray1.add(link3);

        Page page = listFactory.createPage("test", "minko");
        page.add(link1);
        page.add(tray1);
        page.add(link4);

        String re = page.makeHTML();
        System.out.println(re);

        Writer out = new PrintWriter("test.html");
        out.write(re);
        out.close();
    }
}
