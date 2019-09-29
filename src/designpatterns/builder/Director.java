package designpatterns.builder;

public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct(String title, String string, String[] items) {
        builder.makeString(string);
        builder.makeTitle(title);
        builder.makeItems(items);
        builder.close();
    }
}
