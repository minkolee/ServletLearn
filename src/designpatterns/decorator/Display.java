package designpatterns.decorator;

public abstract class Display {

    public abstract int getColumns();

    public abstract int getRows();

    public abstract String getRowText(int rowNumber);

    public final void show() {
        for (int i = 0; i < getRows(); i++) {
            System.out.println(getRowText(i));
        }
    }
}
