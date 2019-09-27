package designpatterns.templatemethod;

public class SingleDisplay extends AbstractDisplay {

    private String string;

    private int width;

    public SingleDisplay(String string) {
        this.string = string;
        //获取字节长度
        this.width = string.getBytes().length;
    }

    //画了一条两端是+号的线
    private void printLine() {
        System.out.print("+");
        for (int i = 0; i < width; i++) {
            System.out.print('-');
        }
        System.out.println("+");
    }

    @Override
    public void open() {
        printLine();
    }

    @Override
    public void print() {
        System.out.println("|" + string + "|");
    }

    @Override
    public void close() {
        printLine();
    }
}
