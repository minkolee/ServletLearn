package thinkinginjava.learn.chapter18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Ex10 {

    //反向打印一下文本文件的内容
    public static void main(String[] args) throws IOException {
        String filename = "D:\\test3.txt";

        String find = "one";

        BufferedReader in = new BufferedReader(new FileReader(filename));

        String s;
        ArrayList<String> arrayList = new ArrayList<>();

        while ((s = in.readLine()) != null) {
            arrayList.add(s);
        }
        in.close();

        for (int i = 0; i < arrayList.size(); i++) {
            String ss = arrayList.get(i);
            if (ss.contains(find)) {
                System.out.println(ss);
            }
        }

    }
}
