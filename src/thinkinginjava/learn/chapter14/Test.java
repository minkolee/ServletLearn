package thinkinginjava.learn.chapter14;

public class Test  {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class aClass = Class.forName("thinkinginjava.learn.chapter14.Gum");
        System.out.println(aClass);
        System.out.println("--------------------------------");
        System.out.println(aClass.getName());
        System.out.println(aClass.isInterface());
        System.out.println(aClass.getSimpleName());
        System.out.println(aClass.getCanonicalName());

        //返回的是一个Class类型的集合, 表示这个类实现的接口们
        for (Class face : aClass.getInterfaces()){
            System.out.println(face);
        } ;

        System.out.println(aClass.getSuperclass());
        Object obj = aClass.newInstance();

        System.out.println(obj);
    }






}


class Gum {
    static {
        System.out.println("Gum loaded");
    }

    @Override
    public String toString() {
        return "Gum{}";
    }
}
