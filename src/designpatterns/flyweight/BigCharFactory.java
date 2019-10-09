package designpatterns.flyweight;

import java.util.HashMap;

public class BigCharFactory {

    //单例模式
    private BigCharFactory() {

    }

    private static BigCharFactory singleton = new BigCharFactory();
    public static BigCharFactory getInstance() {
        return singleton;
    }

    //复用类的关键, 使用了一个Map, 保存已经生成的实例. 如果尚未生成, 就生成一个然后放入其中.
    private HashMap<String, BigChar> pool = new HashMap<>();

    public synchronized BigChar getBigChar(char charname) {
        BigChar bigChar = pool.get(charname + "");
        if (bigChar == null) {
            bigChar = new BigChar(charname);
            pool.put(charname + "", bigChar);
        }
        return bigChar;
    }

}
