package designpatterns.flyweight;

public class BigString {

    private BigChar[] bigChars;

    public BigString(String string) {
        bigChars = new BigChar[string.length()];

        BigCharFactory bigCharFactory = BigCharFactory.getInstance();

        for (int i = 0; i < string.length(); i++) {
            bigChars[i] = bigCharFactory.getBigChar(string.charAt(i));
        }
    }

    public void print() {
        for (BigChar bigChar : bigChars) {
            bigChar.print();
        }
    }

    public BigString(String string, boolean shared) {
        bigChars = new BigChar[string.length()];
        if (shared) {
            //和单参数构造器一样的代码
            BigCharFactory bigCharFactory = BigCharFactory.getInstance();
            for (int i = 0; i < string.length(); i++) {
                bigChars[i] = bigCharFactory.getBigChar(string.charAt(i));
            }
        //如果不共享, 新建BigChar对象填充数组
        } else{
            for (int i = 0; i < string.length(); i++) {
                bigChars[i] = new BigChar(string.charAt(i));
            }
        }
    }

}
