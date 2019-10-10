package designpatterns.command;

import java.util.Stack;

public class MacroCommand implements Command {

    //使用栈结构来存放命令
    private Stack<Command> commands = new Stack<>();

    //宏命令的执行方法是执行所有其中装载的命令
    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }

    //添加一个命令
    public void append(Command command) {
        if (command != null) {
            commands.push(command);
        }
    }

    //弹出最后的命令, 相当于undo
    public void undo() {
        if (!commands.isEmpty()) {
            commands.pop();
        }
    }

    //清空所有命令
    public void clear() {
        commands.clear();
    }

    public void showCommands() {
        for (Command command : commands) {
            System.out.println(command);
        }
    }

    //新添加命令, 仅撤销最后一个
    public Command pop() {
        if (!commands.isEmpty()) {
            return commands.pop();
        } else {
            return null;
        }
    }

    //新添加命令, 获取栈的最后一个元素
    public Command getLastCommand() {
        if (!commands.isEmpty()) {
            return commands.lastElement();
        } else {
            return null;
        }
    }

}
