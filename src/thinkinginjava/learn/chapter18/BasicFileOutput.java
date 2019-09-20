package thinkinginjava.learn.chapter18;

import ajaxlearn.Print;

import java.io.*;

public class BasicFileOutput {

    static String file = "out.out";

    public static void main(String[] args) throws IOException {
        //采取从文件中读字符的方式
        BufferedReader in = new BufferedReader(new FileReader("D:\\test.txt"));

        //实际上应该使用BufferedWriter去写, 不过PrintWriter进行了装饰, 可以更方便的写
        //PrintWriter有print系列方法,比较方便
//        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        PrintWriter out = new PrintWriter(new File(file).getAbsoluteFile());

//        BufferedWriter out = new BufferedWriter(new FileWriter(file));

        int lineCount = 1;

        String s;

        while ((s = in.readLine()) != null) {
//            out.write(lineCount++ + ": " + s + "\n");
            out.println(lineCount++ + ": " + s);
        }

        out.close();

        System.out.println(BufferedInputFile.read(file));

    }
}
