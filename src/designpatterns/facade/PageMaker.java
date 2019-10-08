package designpatterns.facade;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

public class PageMaker {

    private PageMaker() {

    }

    public static void makeWelcomePage(String mailaddr, String filename) {
        try {
            Properties mailprop = Database.getProperties("maildata");
            String username = mailprop.getProperty(mailaddr);
            HtmlWriter writer = new HtmlWriter(new PrintWriter(filename));
            writer.title("Welcome to" + username + "'s page!");
            writer.paragraph("waiting....");
            writer.mailto(mailaddr, username);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void makeLinkPage(String filename) {
        try {
            Properties mailprop = Database.getProperties("maildata");
            HtmlWriter writer = new HtmlWriter(new PrintWriter(filename));
            writer.title("Link Page");

            for (String name : mailprop.stringPropertyNames()) {
                writer.mailto(name, mailprop.getProperty(name) );
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
