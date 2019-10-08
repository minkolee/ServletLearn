package designpatterns.memento;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gamer {

    private int money;
    private List<String> fruits = new ArrayList<>();
    private Random random = new Random();
    private static String[] fruitsname = {"Apple", "Grapes", "Banana", "Orange"};

    public Gamer(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void bet() {
        int dice = random.nextInt(6) + 1;

        if (dice == 1) {
            money += 100;
            System.out.println("所持金钱增加了.");
        } else if (dice == 2) {
            money /= 2;
            System.out.println("所持金钱减少了");
        } else if (dice == 6) {
            String f = getFruit();
            System.out.println("获得了水果: " + f);
            fruits.add(f);
        } else {
            System.out.println("什么都没有发生");
        }

    }

    private String getFruit() {
        String prefix = "";
        if (random.nextBoolean()) {
            prefix = "好吃的";
        }
        return prefix + fruitsname[random.nextInt(fruitsname.length)];
    }

    @Override
    public String toString() {
        return "Gamer{" +
                "money=" + money +
                ", fruits=" + fruits +
                '}';
    }

    //与Memento相关的代码

    //依照现在的游戏状态创建Memento对象, 相当于保存存档
    public Memento createMemento() {
        Memento m = new Memento(money);
        for (String fruit : fruits) {
            m.addFruit(fruit);
        }
        return m;
    }

    //加载状态
    public void restoreMemento(Memento memento) {
        this.money = memento.getMoney();
        this.fruits = memento.getFruits();
    }

}
