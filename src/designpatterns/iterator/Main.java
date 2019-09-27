package designpatterns.iterator;

public class Main {

    public static void main(String[] args) {
//        BookShelf bookShelf = new BookShelf(10);
//
//        for (int i = 0; i < 15; i++) {
//            bookShelf.appendBook(new Book(i + ""));
//        }
//        Iterator bookshelfIterator = bookShelf.iterator();
//
//        while (bookshelfIterator.hasNext()) {
//            System.out.println(bookshelfIterator.next());
//        }

        //测试内部类
//        BookShelfWithInnerClass bookShelfWithInnerClass = new BookShelfWithInnerClass(10);
//        for (int j = 0; j < 8; j++) {
//            bookShelfWithInnerClass.appendBook(new Book(j + ""));
//        }
//        Iterator innerIterator = bookShelfWithInnerClass.iterator();
//        while (innerIterator.hasNext()) {
//            System.out.println(innerIterator.next());
//        }

        //测试增强for对我们编写的书架类的支持
//        BookShelfForEachSupported bookShelfForEachSupported  = new BookShelfForEachSupported(10);
//        for (int j = 0; j < 8; j++) {
//            bookShelfForEachSupported.appendBook(new Book(j + ""));
//        }
//        for (Book book : bookShelfForEachSupported) {
//            System.out.println(book);
//        }

        //测试使用ArrayLIst的书架类
        BookShelfUsingArrayList bookShelfUsingArrayList  = new BookShelfUsingArrayList();
        for (int j = 0; j < 10; j++) {
            bookShelfUsingArrayList.appendBook(new Book(j + ""));
        }
        for (Book book : bookShelfUsingArrayList) {
            System.out.println(book);
        }
    }
}
