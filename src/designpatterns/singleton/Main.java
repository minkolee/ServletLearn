package designpatterns.singleton;

public class Main {

    public static void main(String[] args) {
        System.out.println("Start.");
        SingleTon singleTon1 = SingleTon.getInstance();
        SingleTon singleTon2 = SingleTon.getInstance();
        SingleTon singleTon3 = SingleTon.getInstance();

        System.out.println(singleTon1);
        System.out.println(singleTon2);
        System.out.println(singleTon3);
        System.out.println(singleTon1==singleTon2);
        System.out.println(singleTon1==singleTon3);
        System.out.println(singleTon3==singleTon1);

    }
}
