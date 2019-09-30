package designpatterns.decorator;

public class FullBorder extends Border {


    public FullBorder(Display display) {
        super(display);
    }

    public int getColumns() {
        return display.getColumns() + 2;
    }

    //上下都加框, 所以加2
    public int getRows() {
        return display.getRows() + 2;
    }

    public String getRowText(int row) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("-".repeat(Math.max(0, getColumns())));
        stringBuilder.append("\n").append('|' + display.getRowText(0) + "|\n");
        stringBuilder.append("-".repeat(Math.max(0, getColumns())));
        return stringBuilder.toString();
    }
}
