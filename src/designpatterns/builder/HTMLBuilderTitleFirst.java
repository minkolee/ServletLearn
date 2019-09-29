package designpatterns.builder;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class HTMLBuilderTitleFirst implements Builder {

    private boolean titled = false;

    private String filename;

    private PrintWriter writer;

    @Override
    public void makeTitle(String title) {

        //添加判断
        if (titled) {
            System.out.println("无法重复创建标题");
            return;
        }

        filename = title + ".html";
        try {
            writer = new PrintWriter(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        writer.println("<html><head><title>" + title + "</title></head><body>");
        writer.println("<h1>" + title + "</h1>");

        //成功写入标题之后设置标志位
        titled = true;
    }

    @Override
    public void makeString(String string) {

        //都添加判断标志位的代码
        if (!titled) {
            System.out.println("必须先创建标题");
            return;
        }

        writer.println("<p>" + string + "</p>");
    }

    @Override
    public void makeItems(String[] items) {

        //都添加判断标志位的代码
        if (!titled) {
            System.out.println("必须先创建标题");
            return;
        }

        writer.println("<ol>");
        for (String item : items) {
            writer.println("<li>" + item + "</li>");
        }
        writer.println("</ol>");
    }

    @Override
    public void close() {

        //都添加判断标志位的代码
        if (!titled) {
            System.out.println("必须先创建标题");
            return;
        }

        writer.println("</body></html>");
        writer.close();
    }

    public String getFilename() {
        return filename;
    }

}
