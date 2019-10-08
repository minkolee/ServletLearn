package designpatterns.facade;

public class Main {
    public static void main(String[] args) {
        PageMaker.makeWelcomePage("conyli@conyli.cc", "welcome.html");
        PageMaker.makeLinkPage( "link.html");
    }
}
