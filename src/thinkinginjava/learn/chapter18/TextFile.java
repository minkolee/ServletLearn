package thinkinginjava.learn.chapter18;

import java.io.*;
import java.util.ArrayList;

public class TextFile extends ArrayList<String> {

    //读取一个文件的类
    public static String read(String filename) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(filename).getAbsoluteFile()));
            try {
                String s;
                while ((s = bufferedReader.readLine()) != null) {
                    stringBuilder.append(s);
                    stringBuilder.append("\n");
                }
            } finally {
                bufferedReader.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return stringBuilder.toString();
    }

    //把一个字符串写入到一个文件里
    public static void write(String filename, String text) {
        try {
            System.out.println(new File(filename).getAbsoluteFile());
            PrintWriter out = new PrintWriter(new File(filename).getAbsoluteFile());
            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            System.out.println("未找到文件或者写入失败");
        }
    }


    public static void main(String[] args) {
        //使用起来方便, 读取并获得一个文本文件的全部内容.
        String s = null;
        try {
            s = read("d:\\test.txt");
            System.out.println(s);
        } catch (IOException e) {
            System.out.println(e);
        }

        write("newfile.txt", s);
    }
}
