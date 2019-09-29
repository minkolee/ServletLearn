package designpatterns.abstractfactory.factory;


import java.util.ArrayList;

public abstract class Tray extends Item {
    protected ArrayList<Item> trays = new ArrayList<>();

    public Tray(String caption) {
        super(caption);
    }

    public void add(Item item) {
        trays.add(item);
    }
}
