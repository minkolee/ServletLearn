package thinkinginjava.learn.chapter18;

import java.io.IOException;
import java.io.StringReader;

//这个实际上读取的是一个字符.
public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader(BufferedInputFile.read("D:\\test.txt"));
        //StringReader读出来是int格式, 需要强制转换成char来显示
        int c;
        while ((c = in.read()) != -1) {
            System.out.print((char) c);
        }
    }
}
