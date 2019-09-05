package thinkinginjava.learn.chapter09;

public class Ex14 {

    public static void attack1(CanHit canHit) {
        canHit.hit();
    }
    public static void attack2(CanFire canfire) {
        canfire.fireBall();
    }
    public static void attack3(CanSurround canSurround) {
        canSurround.frozenSurround();
    }
    public static void attack4(FourAbility fourAbility) {
        fourAbility.fullBurst();
    }

    public static void main(String[] args) {
        Nergigante nergigante = new Nergigante();
        attack1(nergigante);
        attack2(nergigante);
        attack3(nergigante);
        attack4(nergigante);
    }
}

class Monster {
    private int hp = 8000;

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}

interface CanHit {
    void hit();

    void hitAir();
}

interface CanFire {
    void fireBreath();

    void fireBall();
}

interface CanSurround {

    void frozenSurround();

    void fireSurroud();
}

interface FourAbility extends CanFire, CanSurround, CanHit {

    void fullBurst();

}

class Nergigante implements FourAbility {
    @Override
    public void hit() {
        System.out.println("开始龙车啦");
    }

    @Override
    public void hitAir() {
        System.out.println("俯冲攻击");
    }

    @Override
    public void fireBreath() {
        System.out.println("喷射火焰");
    }

    @Override
    public void fireBall() {
        System.out.println("喷射火球");
    }

    @Override
    public void frozenSurround() {
        System.out.println("放出冷气");
    }

    @Override
    public void fireSurroud() {
        System.out.println("放出粉尘");
    }

    @Override
    public void fullBurst() {
        System.out.println("火力全开");
    }
}