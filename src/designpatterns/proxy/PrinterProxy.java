package designpatterns.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class PrinterProxy implements Printable {

    private String name;

    //给被代理类留的一个指针
    private Printable real;

    public PrinterProxy(String name) {
        this.name = name;
    }

    public PrinterProxy(String name, String classname) {
        this.name = name;
        try {
            Class printer = Class.forName(classname);
            Constructor con = printer.getConstructor(String.class);
            real = (Printable) con.newInstance(name);
        } catch (Exception e) {
            System.out.println("创建打印机错误, 将创建默认打印机");
            real = new Printer("默认打印机");
        }
    }

    @Override
    public synchronized void  setPrinterName(String name) {
        this.name = name;
        if (real != null) {
            real.setPrinterName(name);
        }
    }

    @Override
    public String getPrinterName() {
        return name;
    }

    @Override
    public void print(String s) {
        createPrinter();
        real.print(s);
    }

    private synchronized void createPrinter() {
        if (real == null) {
            real = new Printer(name);
        }
    }
}
