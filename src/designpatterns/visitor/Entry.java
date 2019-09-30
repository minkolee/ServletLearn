package designpatterns.visitor;


import java.util.Iterator;

public abstract class Entry implements Element {

    public abstract String getName();

    public abstract int getSize();

    //这个方法供覆盖
    public Entry addEntry(Entry entry) throws FileTreatmentException {
        throw new FileTreatmentException();
    };

    public void printList() {
        printList("");
    }

    //供子类覆盖的方法, 打印前缀, 由子类实现
    protected abstract void printList(String prefix);

    @Override
    public String toString() {
        return getName() + "(" + getSize() + ")";
    }

    public Iterator iterator() throws FileTreatmentException {
        throw new FileTreatmentException();
    }

}
