package designpatterns.command;

import java.awt.*;

public class DrawCanvas extends Canvas implements Drawable {

    private Color color = Color.red;

    private int radius = 6;

    private MacroCommand history;

    public DrawCanvas(int width, int height, MacroCommand history) {
        setSize(width, height);
        setBackground(Color.white);
        this.history = history;
    }

    //这个命令用于重复执行一次, 也就是重复绘制一次
    public void paint(Graphics graphics) {
        history.execute();
    }

    public void draw(int x, int y) {
        Graphics g = getGraphics();
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }

}
