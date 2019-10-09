package designpatterns.proxy;

public class Main {

    public static void main(String[] args) {
        Printable proxy = new PrinterProxy("HP", "designpatterns.proxy.Printer");

        proxy.print("Test Page");
    }
}
