package thinkinginjava.learn.chapter18;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class FormattedMemoryInput {

    public static void main(String[] args) {
        try {
            DataInputStream in = new DataInputStream(new ByteArrayInputStream(BufferedInputFile.read("D:\\test.txt").getBytes()));
//            while (true) {
//                //readByte()只能一个一个的读, 读到最后会产生一个EOF异常
//
//                System.out.println((char) in.readByte());
//            }

            while (in.available() != 0) {
                System.out.println(in.readByte());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
