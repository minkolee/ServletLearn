package thinkinginjava.learn.chapter09;

import thinkinginjava.sep05.MonsterHunter;

public class Ex05 implements MonsterHunter {

    @Override
    //必须是public方法, 否则编译器会说权限比重写的方法低了, 不让编译
    public void playWorld() {
        System.out.println("Monster Hunter get all trophies");
    }

    @Override
    public void playIceBorne() {
        System.out.println("IceBorne will continue");

    }

    @Override
    public void playNext() {
        System.out.println("Will be on PS5");
    }

    public static void main(String[] args) {
        MonsterHunter monsterHunter = new Ex05();
        monsterHunter.playIceBorne();
        monsterHunter.playNext();
        monsterHunter.playWorld();
    }
}
