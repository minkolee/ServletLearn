package designpatterns.iterator;

public class BookShelf implements Aggregate {

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }

    private int last = 0;

    private Book[] books;

    public BookShelf(int length) {
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
}
