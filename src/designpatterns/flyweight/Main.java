package designpatterns.flyweight;

public class Main {

    public static void main(String[] args) {
        String n = "09821908980218090985309820941980098124342189126858721093048-9859821891002309859080988093219083890210988905432849084";

        new BigString(n,false).print();

        Runtime.getRuntime().gc();

        long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        System.out.print("使用内存 = " + used);

    }
}
