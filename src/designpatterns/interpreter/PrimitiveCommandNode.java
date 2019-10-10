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
}
