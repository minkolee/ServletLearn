package thinkinginjava.learn.chapter18.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetData {

    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        int i =0;

        //文件内容是UTF-8格式存放的 "三鹅"
        FileChannel fc = new FileInputStream("new.out").getChannel();
        fc.read(bb);
        bb.flip();
        //bb.limit是总长度, 打印出了6个Non-zero, 可见读入了6字节, bb.limit()就是6
        while (i++ < bb.limit()) {
            if (bb.get() != 0) {
                System.out.println("Non-zero");

            }
        }
        //将内部指针返回到开头
        bb.rewind();

        //通过ByteBuffer写点基本类型, 可以看到虽然写了一个a, 实际上文件大小是1024字节, 说明把空白也一起写进去了.
        //而且写的是一个char, 也就是16位, 打开文件可以看到前边是一个0
        ByteBuffer bbForOutput = ByteBuffer.allocate(BSIZE);
        bbForOutput.asCharBuffer().put("a");
        FileChannel out = new FileOutputStream("1.out").getChannel();
        out.write(bbForOutput);
        bbForOutput.clear();
        out.close();

        //读出来前两位是0 97, 说明写的是16位的 97 ,也就是a的ASCII码对应的数字
        FileChannel in = new FileInputStream("1.out").getChannel();
        in.read(bbForOutput);
        bbForOutput.flip();
        System.out.println(bbForOutput.get());
        System.out.println(bbForOutput.get());

    }
}
