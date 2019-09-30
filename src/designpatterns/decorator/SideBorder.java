package designpatterns.decorator;

public class SideBorder extends Border {

    private char decoChar;

    public SideBorder(Display display, char decoChar) {
        super(display);
        this.decoChar = decoChar;
    }


    public int getColumns() {
        return 2 + display.getColumns();
    }

    public int getRows() {
        return display.getRows();
    }

    public String getRowText(int row) {
        return decoChar + display.getRowText(row) + decoChar;
    }
}
