package designpatterns.proxy;

public class Printer implements Printable {

    private String name;

    public Printer() {
        heavyJob("正在生成实例...");
    }

    public Printer(String name) {
        this.name = name;
        heavyJob("正在生成" + name + "实例...");
    }

    @Override
    public synchronized void setPrinterName(String name) {
        this.name = name;
    }

    @Override
    public String getPrinterName() {
        return name;
    }

    @Override
    public void print(String s) {
        System.out.print("=====");
        System.out.print(name);
        System.out.println("=====");
        System.out.println(s);
    }

    private void heavyJob(String msg) {
        System.out.println(msg);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.print(e);
        }
        System.out.println("生成完毕");
    }
}
