package thinkinginjava.learn.chapter18.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class UsingBuffers {

    //交换两个buffer两个位置的字符
    //一开始进来的时候mark和position都是0. 先获取两个字符, 然后让mark=当前的position, 之后将position向后返回2个位置.写完之后再进行下一步
    private static void symmertricScramble(CharBuffer buffer) {
        int count = 0;
        while (buffer.hasRemaining()) {
            //get会移动position, 所以先获取两个位置的字符, 然后重置position的位置,再按照相反顺序写入
            char c1 = buffer.get();
            char c2 = buffer.get();
            buffer.position(buffer.position() - 2);
            buffer.put(c2).put(c1);
            count++;
        }
        System.out.println(count);

    }

    public static void main(String[] args) {
        char[] data = "UsingBuffers".toCharArray();
        //注意char是16位=2字节, 所以分配的长度是data.length的2倍
        ByteBuffer byteBuffer = ByteBuffer.allocate(data.length * 2);
        //转换成CharBuffer视图进行写入
        CharBuffer charBuffer = byteBuffer.asCharBuffer();
        charBuffer.put(data);
        //写完之后复位position, 先打印一次, 就是写入的内容
        charBuffer.rewind();
        charBuffer.mark();
        System.out.println(charBuffer);
        System.out.println("--------------------------");
        //交换前两个字节的内容
        symmertricScramble(charBuffer);
        charBuffer.rewind();
        System.out.println(charBuffer);

    }
}
