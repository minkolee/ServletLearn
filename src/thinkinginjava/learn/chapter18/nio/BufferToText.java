package thinkinginjava.learn.chapter18.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class BufferToText {

    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        //打开一个文件写入一小段字符
        FileChannel fc = new FileOutputStream("new.out").getChannel();
        fc.write(ByteBuffer.wrap("三鹅".getBytes()));
        fc.close();

        //打开这个文件,尝试用ByteBuffer直接读字符串
        fc = new FileInputStream("new.out").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        fc.read(buffer);
        buffer.flip();
        //这里无法工作
        System.out.println(buffer.asCharBuffer());

        //设置buffer重新可以读
        buffer.rewind();

        //使用Charset类,采用系统环境解码buffer, Charset也是新NIO的类
        String encodedString = System.getProperty("file.encoding");
        System.out.println("Decoding using " + encodedString + ": " + Charset.forName(encodedString).decode(buffer));

        //写入的时候就指定编码
        fc = new FileOutputStream("encodedin.txt").getChannel();
        //使用UTF-16小端法写入
        buffer = ByteBuffer.wrap("采用UTF-16写入的内容".getBytes(StandardCharsets.UTF_8));
        fc.write(buffer);
        fc.close();

        //同样UI踹死UTF-16LE读出,经过测试可以发现默认的UTF-16就是UTF-16BE
        fc = new FileInputStream("encodedin.txt").getChannel();
        buffer = ByteBuffer.allocate(BSIZE);
        fc.read(buffer);
        buffer.flip();
        fc.close();
        System.out.println(StandardCharsets.UTF_8.decode(buffer));

    }
}
