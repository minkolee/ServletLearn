package designpatterns.bridge;

import java.io.IOException;

public abstract class DisplayImpl {

    public abstract void rawOpen() throws IOException;

    public abstract void rawPrint();

    public abstract void rawClose();
}
