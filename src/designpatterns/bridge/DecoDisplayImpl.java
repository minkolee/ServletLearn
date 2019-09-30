package designpatterns.bridge;

import java.io.IOException;

public class DecoDisplayImpl extends DisplayImpl {

    private char prefix;
    private char deco;
    private char suffix;


    public DecoDisplayImpl(char prefix, char deco, char suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
        this.deco = deco;
    }

    @Override
    public void rawOpen() throws IOException {
        System.out.print(prefix);
    }

    @Override
    public void rawPrint() {
        System.out.print(deco);
    }

    @Override
    public void rawClose() {
        System.out.println(suffix);
    }
}
