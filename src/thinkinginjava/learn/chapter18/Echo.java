package thinkinginjava.learn.chapter18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Echo {

    public static void main(String[] args) throws IOException {
        //先用适配器套壳InputStream变成Reader ,再套壳BufferedReader
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String s;
        while ((s = in.readLine()) != null && s.length() != 0) {
            System.out.println(s);
        }
    }


}
