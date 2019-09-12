package thinkinginjava.learn.chapter11;


import java.util.*;

public class Ex04 {

    public static void main(String[] args) {

        Monsters monsters = Monsters.getMonsters();

        System.out.println(monsters.getSize());

        ArrayList<String> arrayListMonsters = new ArrayList<>();
        HashSet<String> hashSet = new HashSet<>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();

        for (int i = 0; i < 60; i++) {
            String name = monsters.next();
            arrayListMonsters.add(name);
            hashSet.add(name);
            linkedHashSet.add(name);
            treeSet.add(name);
        }

        System.out.println(arrayListMonsters);
        System.out.println(hashSet);
        System.out.println(linkedHashSet);
        System.out.println(treeSet);

        monsters.printAddress();

    }


}

class Monsters {

    private Monsters() {

    }

    private static Monsters monsters = new Monsters();

    private int index = 0;
    ArrayList<String> monsterName = new ArrayList<>();

    public static Monsters getMonsters() {
        List<String> list = Arrays.asList("アン・イシュワルダ", "アンジャナフ", "アンジャナフ亜種", "イヴェルカーナ", "イビルジョー",
                "怒り喰らうイビルジョー", "イャンガルルガ", "ヴァルハザク", "死を纏うヴァルハザク", "ヴォルガノス", "ウラガンキン",
                "オドガロン", "オドガロン亜種", "キリン", "クシャルダオラ", "クルルヤック", "ジュラトドス", "ジンオウガ", "ゼノ・ジーヴァ", "ゾラ・マグダラオス",
                "ツィツィヤック", "ディアブロス", "ディアブロス亜種", "ティガレックス", "ディノバルド", "ディノバルド亜種", "テオ・テスカトル", "ドスギルオス",
                "ドスジャグラス", "ドドガマル", "トビカガチ", "トビカガチ亜種", "ナナ・テスカトリ", "ナルガクルガ", "ネルギガンテ", "悉くを殲ぼすネルギガンテ",
                "ネロミェール", "パオウルムー", "パオウルムー亜種", "バゼルギウス", "紅蓮滾るバゼルギウス", "バフバロ", "プケプケ", "プケプケ亜種", "ブラキディオス", "ブラントドス",
                "ベヒーモス", "ベリオロス", "ボルボロス", "マム・タロト", "ラージャン", "ラドバルキン", "リオレイア", "リオレイア亜種", "リオレウス", "リオレウス亜種", "レイギエナ"
                , "凍て刺すレイギエナ", "レーシェン", "エンシェント・レーシェン");
        monsters.monsterName.addAll(list);
        return monsters;
    }


    @Override
    public String toString() {
        return "Monsters{" +
                "monsterName=" + monsterName +
                '}';
    }

    public int getSize() {
        return this.monsterName.size();
    }

    public String next() {
        int length = monsterName.size();

        if (index >= length) {
            index = 0;
        }
        return monsterName.get(index++);
    }

    public boolean hasNext() {
        return monsterName.size() != 0;
    }

    public void printAddress() {
        System.out.println(super.toString());
    }

}