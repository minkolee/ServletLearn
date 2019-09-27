package designpatterns.iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class BookShelfUsingArrayList implements Iterable<Book> {

    @Override
    public Iterator<Book> iterator() {
        return new BookShelfInnerIterator();
    }

    //改用ArrayList进行实际存放Book对象的容器
    private ArrayList<Book> books = new ArrayList<>();

    //以下的方法都是对ArrayList API的包装
    public Book getBookAt(int index) {
        return books.get(index);
    }

    public void appendBook(Book book) {
        books.add(book);
    }

    public int getLength() {
        return books.size();
    }

    //内部类在初始化的时候加上一个获取当前总Book数量的变量
    public class BookShelfInnerIterator implements Iterator<Book> {

        private int index;

        private int size;

        BookShelfInnerIterator() {
            index = 0;
            size = getLength();
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Book next() {
            return getBookAt(index++);
        }
    }
}
