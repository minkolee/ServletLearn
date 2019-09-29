package designpatterns.abstractfactory.listfactory;

import designpatterns.abstractfactory.factory.Item;
import designpatterns.abstractfactory.factory.Page;

public class ListPage extends Page {

    public ListPage(String title, String author) {
        super(title, author);
    }

    //这个方法比较简单,添加标题信息, 然后就递归将其中所有的Item对象的HTML代码放进一个ul列表, 最后生成HTML文件.
    @Override
    public String makeHTML() {
        StringBuilder result = new StringBuilder();

        result.append("<html><head><title>" + title + "</title></head>\n")
                .append("<body>\n")
                .append("<h1>" + title + "</h1>")
                .append("<ul>");

        for (Item item : content) {
            result.append(item.makeHTML());
        }

        result.append("</ul>").append("<hr><address>" + author + "</address>")
        .append("</body></html>");
        return result.toString();
    }
}
