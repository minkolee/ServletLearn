package designpatterns.decorator;

public class Main {

    public static void main(String[] args) {
        Display display = new StringDisplay("saner");

        System.out.println(display.getRowText(0));
        System.out.println(display.getColumns());
        System.out.println(display.getRows());

        System.out.println("================================");

        Display decoratedDisplay = new SideBorder(display, '|');

        System.out.println(decoratedDisplay.getRowText(0));
        System.out.println(decoratedDisplay.getColumns());
        System.out.println(decoratedDisplay.getRows());

        System.out.println("================================");

        decoratedDisplay = new FullBorder(display);
        System.out.println(decoratedDisplay.getRowText(0));
        System.out.println(decoratedDisplay.getColumns());
        System.out.println(decoratedDisplay.getRows());

        decoratedDisplay = new FullBorder(new SideBorder(new SideBorder(new FullBorder(display), '|'), '*'));
        System.out.println(decoratedDisplay.getRowText(0));

    }
}
