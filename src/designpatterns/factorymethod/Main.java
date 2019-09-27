package designpatterns.factorymethod;

public class Main {

    public static void main(String[] args) {
        Factory factory = new IDCardFactory();

        Product idCard1 = factory.create("saner");
        Product idCard2 = factory.create("sixtuan");
        Product idCard3 = factory.create("owl");

        idCard1.use();
        idCard2.use();
        idCard3.use();

        System.out.println(factory);
    }
}
