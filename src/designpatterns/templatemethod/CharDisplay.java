package designpatterns.templatemethod;

public class CharDisplay extends AbstractDisplay {

    private char aChar;

    public CharDisplay(char aChar) {
        this.aChar = aChar;
    }



    @Override
    protected void open() {
        System.out.print("<<");
    }

    @Override
    protected void print() {
        System.out.print(aChar);
    }

    @Override
    protected void close() {
        System.out.println(">>");
    }

}
