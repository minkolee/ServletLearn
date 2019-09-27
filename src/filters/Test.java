package filters;

import designpatterns.templatemethod.AbstractDisplay;
import designpatterns.templatemethod.CharDisplay;

public class Test {


    public static void main(String[] args) {
        AbstractDisplay a1 = new CC('c');
        a1.display();
    }
}

class CC extends CharDisplay {

    public CC(char c) {
        super(c);
    }

    @Override
    protected void open() {
        super.open();
    }

    @Override
    protected void print() {
        super.print();
    }

    @Override
    protected void close() {
        super.close();
    }
}