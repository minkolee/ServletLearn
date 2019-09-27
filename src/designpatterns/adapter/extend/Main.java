package designpatterns.adapter.extend;

public class Main {

    public static void main(String[] args) {
        Print p = new PrintBannerAdapter2("saner");
        p.printStrong();
        p.printWeak();

    }
}
