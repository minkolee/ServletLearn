package designpatterns.interpreter;


import java.util.ArrayList;

public class CommandListNode extends Node {

    private ArrayList<Node> list = new ArrayList<>();

    @Override
    public void parse(Context context) throws ParseException {
        while (true) {
            if (context.currentToken() == null) {
                throw new ParseException("Missing end");
            } else if (context.currentToken().equals("end")) {
                context.skipToken("end");
                break;
            } else {
                Node commandNode = new CommandNode();
                commandNode.parse(context);
                list.add(commandNode);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[List ");
        for (Node node : list) {
            stringBuilder.append(node.toString()).append(" ");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void run() {
        for (Node node : list) {
            node.run();
        }
    }
}
