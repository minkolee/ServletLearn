package thinkinginjava.learn.chapter21.sync;

public class SerialNumberGenerator {

    private static volatile int number = 0;

    //这个函数线程不安全, 由于是静态方法, 监视器可以设置为类
    public static int nextSerialNumber() {

        //这里有问题, 可能会在返回的时候, 获得相同的数字, 导致之后的检测出现问题
        return number++;
    }
}
