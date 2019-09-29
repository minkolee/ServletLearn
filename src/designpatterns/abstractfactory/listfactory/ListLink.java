package designpatterns.abstractfactory.listfactory;

import designpatterns.abstractfactory.factory.Link;

public class ListLink extends Link {

    public ListLink(String caption, String url) {
        super(caption, url);
    }

    //Link类是创建单独的链接
    @Override
    public String makeHTML() {
        return "<li><a href=\"" + url + "\">" + caption + "</a></li>";
    }

}
