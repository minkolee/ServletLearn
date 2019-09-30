package designpatterns.decorator;

public class StringDisplay extends Display {

    private String string;

    public StringDisplay(String string) {
        this.string = string;
    }

    @Override
    public int getColumns() {
        return string.length();
    }

    @Override
    public int getRows() {
        return 1;
    }

    @Override
    public String getRowText(int rowNumber) {
        if (rowNumber == 0) {
            return string;
        } else {
            return "";
        }
    }
}
