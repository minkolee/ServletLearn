package designpatterns.interpreter;

public class PrimitiveCommandNode extends Node {

    private String name;

    @Override
    public void parse(Context context) throws ParseException {
        name = context.currentToken();
        context.skipToken(name);

        if (!name.equals("go") && !name.equals("left") && !name.equals("right")) {
            throw new ParseException(name + " is undefined.");
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        switch (name) {
            case "go":
                System.out.println("小车前进");
                break;
            case "left":
                System.out.println("小车左转");
                break;
            case "right":
                System.out.println("小车右转");
                break;
        }
    }
}
