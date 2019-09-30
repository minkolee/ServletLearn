package designpatterns.visitor;

import java.util.ArrayList;
import java.util.Iterator;

public class Directory extends Entry {

    private String directoryName;

    //这个容器要注意, 目录可以嵌套目录, 所以泛型是一个Entry, 这是实现Composite设计模式的关键
    private ArrayList<Entry> directory = new ArrayList<>();

    public Directory(String directoryName) {
        this.directoryName = directoryName;
    }

    @Override
    public String getName() {
        return directoryName;
    }

    //注意获取大小, 是不能够直接获取, 而是要用容器中的元素计算的
    //这个方法也是要递归的, 所以放到了抽象类中作为Entry的方法让大家来实现
    @Override
    public int getSize() {
        int totalSize = 0;
        for (Entry entry : directory) {
            totalSize += entry.getSize();
        }
        return totalSize;
    }

    //这个也是递归方法, 这里就要打印容器中的全部Entry对象
    @Override
    protected void printList(String prefix) {
        //由于是一个目录, 因此先显示自身的目录名称, toString()方法已经由Entry类实现
        System.out.println(prefix + "/" + this);
        //再打印容器内的所有Entry条目, 这里要调用Entry自己的打印方法, 打印出传入的前缀和自己的名称, 这个传入的前缀在每次都会递归增加上一层目录
        for (Entry entry : directory) {
            entry.printList(prefix + "/" + directoryName);
        }
    }

    //可供链式调用的添加一个条目的方法, 用于组装目录结构
    @Override
    public Entry addEntry(Entry entry) throws FileTreatmentException {
        directory.add(entry);
        return this;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Iterator<Entry> iterator() {
        return directory.iterator();
    }
}
