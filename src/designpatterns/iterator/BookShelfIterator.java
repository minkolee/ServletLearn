package designpatterns.iterator;

public class BookShelfIterator implements Iterator {

    //要根据一个书架对象生成对应的迭代器, 所以在构造器中传入一个书架对象
    private BookShelf bookShelf;

    //然后需要有一个遍历书架的内容的变量
    private int index;

    BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    //这个方法的关键是判断是否还能继续取下一个, 当索引小于书架内书的数量的时候, 就说明可以来取出书对象
    @Override
    public boolean hasNext() {
        return index < bookShelf.getLength();
    }

    //这个是实际取出下一个
    @Override
    public Object next() {
        return bookShelf.getBookAt(index++);
    }

}
