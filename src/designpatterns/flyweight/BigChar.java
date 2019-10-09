package designpatterns.flyweight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BigChar {

    private char charname;

    private String fontdata;

    public BigChar(char charname) {
        this.charname = charname;
        try {
            //读取字体数据到fontdata中
            BufferedReader bufferedReader = new BufferedReader(new FileReader("big" + charname + ".txt"));
            String line;
            StringBuilder buffer = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                buffer.append(line).append("\n");
            }
            bufferedReader.close();
            this.fontdata = buffer.toString();
        } catch (IOException e) {
            this.fontdata = charname + "?";
        }
    }

    public void print() {
        System.out.print(fontdata);
    }

}
