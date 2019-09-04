package thinkinginjava.learn.chapter07;

public class Ex18 {

    public static void main(String[] args) {
        System.out.println(ラージャン.HP);

        ナルガクルガ ナルガ = new ナルガクルガ(7000);
        ナルガクルガ亜種 ナルガ2 = new ナルガクルガ亜種(9000);

        System.out.println(ナルガ.getHP());
        System.out.println(ナルガ2.getHP());
    }

}

class ラージャン {
    public static final int HP = 12000;
}

class ナルガクルガ {
    private final int HP;

    ナルガクルガ(int hp) {
        this.HP = hp;
    }

    public int getHP() {
        return HP;
    }
}

class ナルガクルガ亜種 extends ナルガクルガ {
    final int HP = 7000;

    ナルガクルガ亜種(int hp) {
        super(hp);
    }


}