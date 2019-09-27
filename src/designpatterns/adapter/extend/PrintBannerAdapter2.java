package designpatterns.adapter.extend;


public class PrintBannerAdapter2 implements Print {

    private Banner banner;

    public PrintBannerAdapter2(String string) {
        this.banner = new Banner(string);
    }

    @Override
    public void printWeak() {
        banner.showWithParen();
    }

    @Override
    public void printStrong() {
        banner.showWithAster();
    }
}
