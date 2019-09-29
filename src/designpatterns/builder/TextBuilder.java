package designpatterns.builder;

public class TextBuilder implements Builder {

    private StringBuffer result = new StringBuffer();

    @Override
    public void makeTitle(String title) {
        result.append("===========================================\n").append("[").append(title).append("]\n").append("\n");
    }

    @Override
    public void makeString(String string) {
        result.append("*").append(string).append("\n").append("\n");
    }

    @Override
    public void makeItems(String[] items) {
        for (String item : items) {
            result.append(" . ").append(item).append("\n");
        }
    }

    @Override
    public void close() {
        result.append("===========================================\n");
    }

    public String getResult() {
        return result.toString();
    }
}
