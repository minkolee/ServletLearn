package designpatterns.visitor;


import java.util.Iterator;

public class SizeVisitor extends Visitor {

    private int size = 0;

    @Override
    public void visit(File file) {
        this.size += file.getSize();
    }

    @Override
    public void visit(Directory directory) {
        for (Iterator<Entry> entries = directory.iterator(); entries.hasNext(); ) {
            entries.next().accept(this);
        }
    }

    public int getSize() {
        return size;
    }
}
