package thinkinginjava.learn.chapter18.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {

    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        FileChannel fc = new FileOutputStream("newfile.txt").getChannel();
        fc.write(ByteBuffer.wrap("中文支持吗 ".getBytes()));
        fc.close();

        fc = new RandomAccessFile("newfile.txt", "rw").getChannel();
        fc.write(ByteBuffer.wrap("中文呢".getBytes()));

        fc = new FileInputStream("newfile.txt").getChannel();
        //创建一个缓冲区对象
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        fc.read(buffer);
        buffer.flip();

        while (buffer.hasRemaining()) {
            System.out.println((char)buffer.get());
        }

    }
}
