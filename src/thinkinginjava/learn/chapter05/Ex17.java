package thinkinginjava.learn.chapter05;

public class Ex17 {


    public static void main(String[] args) {
        StringArray[] stringArrays;
        stringArrays = new StringArray[10];
        //不会调用StringArray, 因为没有创建对象

        stringArrays[0] = new StringArray("saner");

    }


}

//数组
class StringArray {
    StringArray(String s) {
        System.out.println(s);
    }
}