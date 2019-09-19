package thinkinginjava.learn.chapter18;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EX17 {

    public static HashMap<Character, Integer> count(String s) {
        //替换所有空白字符
        String temp = s.replaceAll("\\s", "");
        System.out.println(temp);

        HashMap<Character, Integer> hashMap = new HashMap<>();
        //
        for (int i = 0; i < temp.length(); i++) {
            char chr = temp.charAt(i);
            hashMap.merge(chr, 1, Integer::sum);
        }

        return hashMap;

    }

    public static void main(String[] args) {
        String s = null;
        try {
            s = TextFile.read("newfile.txt");
        } catch (IOException e) {
            System.out.println(e);
        }

        if (s == null) {
            System.out.println("文件为空");
            System.exit(1);
        } else {
            HashMap<Character, Integer> hashMap = count(s);
            System.out.println(hashMap);
        }
    }
}
