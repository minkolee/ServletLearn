package thinkinginjava.learn.chapter18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedInputFile {

    public static String read(String filename) throws IOException {
        //FileReader适配FileInputStream, 而FileInputStream是基础的文件读取类, BufferedReader是装饰
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        //readline方法会去掉换行符, 所以要补上换行符
        while ((s = in.readLine()) != null) {
            sb.append(s).append("\n");
        }
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        String filename = "D:\\Coding\\Java-Exercises\\src\\thinkinginjava\\learn\\chapter18\\DirList2.java";
        System.out.println(read(filename));

    }

}
