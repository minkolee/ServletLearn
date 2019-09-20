package thinkinginjava.learn.chapter18.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.nio.channels.FileChannel;

public class Endians {

    private static final int BSIZE = 256;


    public static void main(String[] args) throws IOException {
        //写一个100
        ByteBuffer byteBuffer = ByteBuffer.allocate(BSIZE);
        //小端法写入
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.asShortBuffer().put((short) 100);
        FileChannel out = new FileOutputStream("1.out").getChannel();
        out.write(byteBuffer);
        out.close();

        //按字节读刚才的文件
        FileChannel in = new FileInputStream("1.out").getChannel();
        byteBuffer.clear();
        in.read(byteBuffer);
        byteBuffer.flip();
        //打印两个字节, 是 100 和 0
        System.out.println(byteBuffer.get());
        System.out.println(byteBuffer.get());

    }
}
