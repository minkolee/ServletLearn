package designpatterns.bridge;

import java.io.IOException;

public class Display {

    private DisplayImpl impl;

    public Display(DisplayImpl impl) {
        this.impl = impl;
    }

    public void open() throws IOException {
        impl.rawOpen();
    }

    public void print() {
        impl.rawPrint();
    }

    public void close() {
        impl.rawClose();
    }

    public final void display() throws IOException {
        open();
        print();
        close();
    }
}
