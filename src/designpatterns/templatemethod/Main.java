package designpatterns.templatemethod;

import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) {
        AbstractDisplay a1 = new CharDisplay('s');
        AbstractDisplay a2 = new SingleDisplay("s");
        a1.display();
        a2.display();
    }
}
