package thinkinginjava.learn.chapter18;

import java.io.*;

public class BasicFileOutputShort {

    static String file = "out.out";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("D:\\test.txt"));
        PrintWriter out = new PrintWriter(file);
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            out.println(lineCount++ + ": " + s);
        }
        out.close();
        in.close();
        System.out.println(BufferedInputFile.read(file));
    }
}
