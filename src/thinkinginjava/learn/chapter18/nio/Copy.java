package thinkinginjava.learn.chapter18.nio;

import java.io.*;
import java.nio.channels.FileChannel;

public class Copy {

    public static void main(String[] args) throws IOException {
        File file1 = new File("D:\\Coding\\Java-Exercises\\out.out");
        File file2 = new File("D:\\test2.txt");

        FileChannel in = new FileInputStream(file1).getChannel();
        FileChannel out = new FileOutputStream(file2).getChannel();

        in.transferTo(0, in.size(), out);
    }

}
