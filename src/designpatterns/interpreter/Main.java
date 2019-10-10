package designpatterns.interpreter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("program.txt"));

            String text;

            while ((text = bufferedReader.readLine()) != null) {
                System.out.println("text = " + text + "\"");
                Node node = new ProgramNode();
                node.parse(new Context(text));
                System.out.println(node);
            }
        } catch (IOException e) {
            System.out.print("文件读取错误");
        } catch (ParseException e) {
            System.out.print("解析错误");
        }

    }


    public void run(Node node) {

    }
}
