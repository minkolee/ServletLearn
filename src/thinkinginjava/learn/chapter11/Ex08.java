package thinkinginjava.learn.chapter11;

import java.util.Iterator;

public class Ex08 {

    public static void main(String[] args) {
        Monsters monsters = Monsters.getMonsters();

        for (String s : monsters.monsterName) {
            System.out.println(s);
        }
    }

}
