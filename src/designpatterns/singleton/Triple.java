package designpatterns.singleton;

public class Triple {

    private static Triple[] triples = new Triple[3];

    static {
        for (int i = 0; i < 3; i++) {
            triples[i] = new Triple(i);
        }
    }

    private int number;

    private Triple(int i) {
        this.number = i;
    }


    private static Triple getInstance(int index) {
        if (index < 0 || index > 2) {
            throw new RuntimeException("索引错误");
        }
        return triples[index];
    }

    public static void main(String[] args) {
        //取同一个位置的对象
        Triple triple0 = Triple.getInstance(1);
        Triple triple1 = Triple.getInstance(1);
        Triple triple2 = Triple.getInstance(1);
        System.out.println(triple0);
        System.out.println(triple1);
        System.out.println(triple2);

        //取不同位置对象
        triple0 = Triple.getInstance(0);
        triple1 = Triple.getInstance(1);
        triple2 = Triple.getInstance(2);
        System.out.println(triple0);
        System.out.println(triple1);
        System.out.println(triple2);

    }

}
