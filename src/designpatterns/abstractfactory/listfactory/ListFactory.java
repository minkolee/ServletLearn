package designpatterns.abstractfactory.listfactory;

import designpatterns.abstractfactory.factory.Factory;
import designpatterns.abstractfactory.factory.Link;
import designpatterns.abstractfactory.factory.Page;
import designpatterns.abstractfactory.factory.Tray;

public class ListFactory extends Factory {

    @Override
    public Link createLink(String caption, String url) {
        return new ListLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new ListPage(title, author);
    }
}
