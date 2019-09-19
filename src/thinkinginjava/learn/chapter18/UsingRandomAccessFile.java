package thinkinginjava.learn.chapter18;

import java.io.IOException;
import java.io.RandomAccessFile;

public class UsingRandomAccessFile {

    static String file = "rtest.data";

    static void display() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");

        for (int i = 0; i < 7; i++) {
            System.out.println("Value " + i + ": " + randomAccessFile.readDouble());
        }

        System.out.println(randomAccessFile.readUTF());
        randomAccessFile.close();
    }

    public static void main(String[] args) throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "rw");

        //写7个double和一个字符串
        for (int i = 0; i < 7; i++) {
            rf.writeDouble(i * 1.414);
        }
        rf.writeUTF("This is end of file");
        rf.close();

        display();

        //一个double长度是64位, 也就是8字节, 初始是0
        //已经关闭了就不能再使用, 必须重新打开
        RandomAccessFile rf2 = new RandomAccessFile(file, "rw");
        //0的位置是第一个数字, 很显然这里就应该是第6个数字
        rf2.seek(40);
        //修改第6个数字
        rf2.writeDouble(99999);
        rf2.close();

        //再打印就可以看到第6个数字也就是Value 5发生了改变
        display();
    }
}
