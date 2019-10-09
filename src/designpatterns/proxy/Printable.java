package designpatterns.proxy;

public interface Printable {

    void setPrinterName(String name);

    String getPrinterName();

    void print(String s);
}
