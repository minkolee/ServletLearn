package thinkinginjava.learn.chapter18;

import java.io.*;

public class StoringData {

    public static void main(String[] args) throws IOException {

        //写入字节(二进制文件)
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("target.txt")));

        //write系列方法,需要指定数据类型, 其中的UTF是UTF-8,但是前边加入了Java自己的编码
        out.writeDouble(4.04);
        out.writeInt(10000);
        out.writeUTF("saner");
        out.writeDouble(1.4134);
        out.writeUTF("Square root of 2");
        out.close();

        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("target.txt")));

        //用相同的顺序, 就可以将数据读出, 这也可以用来序列化
        System.out.println(in.readDouble());
        System.out.println(in.readInt());
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());


    }

}
