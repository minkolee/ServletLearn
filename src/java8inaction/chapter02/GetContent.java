package java8inaction.chapter02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.*;

public class GetContent {

    public static String getContent(String filename, ReadFile p) {
        String result = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            result = p.read(bufferedReader);
        } catch (IOException e) {
            System.out.println("处理错误");
        }
        return result;
    }


    public static void main(String[] args) {
        String result = getContent("program.txt", bufferedReader -> bufferedReader.readLine()+ "\n"+bufferedReader.readLine());

        System.out.println(result);

        String result2 = getContent("program.txt", bufferedReader -> bufferedReader.readLine());

        System.out.println(result2);


        String result3 = getContent("program.txt", new ReadFileOneLine());

        System.out.println(result3);

    }

}

