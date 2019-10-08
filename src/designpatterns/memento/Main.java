package designpatterns.memento;

public class Main {

    public static void main(String[] args) {
        Gamer newGamer = new Gamer(100);

        int i = 0;

        for (; i < 5; i++) {
            System.out.println("---------------------回合" + i + "-----------------------");
            newGamer.bet();
            System.out.println(newGamer);
        }

        System.out.println("保存存档");
        Memento memento = newGamer.createMemento();

        for (; i < 10; i++) {
            System.out.println("---------------------回合" + i + "-----------------------");
            newGamer.bet();
            System.out.println(newGamer);
        }

        newGamer.restoreMemento(memento);

        System.out.println(newGamer);
    }
}
