package thinkinginjava.learn.chapter05;

import java.util.Scanner;

public class Ex10 {

    public static void main(String[] args) {
        Book book1 = new Book();
        Book book2 = new Book();

        book1 = null;
        System.gc();

        Scanner scanner = new Scanner(System.in);
        String f = scanner.nextLine();

    }

}


class Book {
    private boolean returned = false;

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public boolean isReturned() {
        return returned;
    }

    @Override
    protected void finalize() {
        this.setReturned(true);
        System.out.println("书被强制返回");
    }
}