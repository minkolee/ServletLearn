package designpatterns.iterator;

import java.util.Iterator;

public class BookShelfForEachSupported implements Iterable<Book> {

    //返回内部类对象
    @Override
    public Iterator<Book> iterator() {
        return new BookShelfInnerIterator();
    }

    private int last = 0;

    private Book[] books;

    public BookShelfForEachSupported(int length) {
        books = new Book[length];
    }

    public Book getBookAt(int index) {
        return this.books[index];
    }

    public void appendBook(Book book) {
        if (last == this.books.length) {
            System.out.println("书架已满, 放入失败");
            return;
        }
        books[last] = book;
        last++;
    }

    public int getLength() {
        return this.last;
    }

    public class BookShelfInnerIterator implements Iterator<Book> {

        private int index;

        BookShelfInnerIterator() {
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < last;
        }

        @Override
        public Book next() {
            return getBookAt(index++);
        }
    }
}
