package designpatterns.builder;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class HTMLBuilder implements Builder {

    private String filename;

    private PrintWriter writer;

    @Override
    public void makeTitle(String title) {
        filename = title + ".html";
        try {
            writer = new PrintWriter(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        writer.println("<html><head><title>" + title + "</title></head><body>");
        writer.println("<h1>" + title + "</h1>");
    }

    @Override
    public void makeString(String string) {
        writer.println("<p>" + string + "</p>");
    }

    @Override
    public void makeItems(String[] items) {
        writer.println("<ol>");
        for (String item : items) {
            writer.println("<li>" + item + "</li>");
        }
        writer.println("</ol>");
    }

    @Override
    public void close() {
        writer.println("</body></html>");
        writer.close();
    }

    public String getFilename() {
        return filename;
    }

}
