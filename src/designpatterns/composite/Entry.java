package designpatterns.composite;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;

public abstract class Entry {

    public abstract String getName();

    public abstract int getSize();

    //这个方法供覆盖
    public Entry addEntry(Entry entry) throws FileTreatmentException{
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

    protected String getAbsoultePath(){
        Entry entry = this.fatherEntry;
        StringBuilder path = new StringBuilder();
        while (entry != null) {
            path.insert(0, "/" + entry.getName());
            entry = entry.fatherEntry;
        }
        return path + "/" + this.getName();
    };

    private Entry fatherEntry = null;

    protected void setFatherEntry(Entry entry){
        fatherEntry = entry;
    };
}
