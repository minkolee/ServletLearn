package designpatterns.visitor;

import java.util.ArrayList;

public class ElementArrayList implements Element {

    private ArrayList<Entry> entries = new ArrayList<>();

    public void add(Entry entry) {
        entries.add(entry);
    }

    @Override
    public void accept(Visitor visitor) {
        for (Entry entry : entries) {
            entry.accept(visitor);
        }
    }
}
