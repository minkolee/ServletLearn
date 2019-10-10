package designpatterns.command;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener, MouseMotionListener, WindowListener {

    private MacroCommand history = new MacroCommand();

    private DrawCanvas canvas = new DrawCanvas(400, 400, history);

    private JButton clearButton = new JButton("CLEAR");

    //新建一个绿色按钮和红色按钮
    private JButton greenButton = new JButton("GREEN");
    private JButton redButton = new JButton("RED");

    public Main(String title) {
        super(title);
        this.addWindowListener(this);
        canvas.addMouseMotionListener(this);
        clearButton.addActionListener(this);

        //为颜色按钮添加事件监听
        greenButton.addActionListener(this);
        redButton.addActionListener(this);

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);

        //添加颜色按钮到界面上
        buttonBox.add(greenButton);
        buttonBox.add(redButton);


        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);
        pack();
        show();



    }

    //以下是监听事件和鼠标事件的接口方法

    //点击clear按钮之后, 清除历史命令, 重置画布
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearButton) {
            history.showCommands();
            history.clear();
            canvas.repaint();
        }

        //为绿色按钮编写事件
        if (e.getSource() == greenButton) {
            canvas.setColor(Color.green);
        }
        //为红色按钮编写事件
        if (e.getSource() == redButton) {
            canvas.setColor(Color.red);
        }
    }

    //这个方法处理鼠标拖动的事件
    //每次拖动鼠标, 创建一个保存了当前位置的command命令, 执行, 之后加入到历史命令中
    @Override
    public void mouseDragged(MouseEvent e) {
        Command command = new DrawCommand(canvas, e.getPoint());
        command.execute();
        history.append(command);
    }

    //这个留空, 即鼠标移动的时候不做处理
    @Override
    public void mouseMoved(MouseEvent e) {

    }

    //以下是WindowListener的方法, 仅仅使用到了窗口关闭的功能, 其他都留空
    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    public static void main(String[] args) {
        new Main("Command Pattern");
    }
}
