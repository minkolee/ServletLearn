package java8inaction.chapter02;

import java.io.BufferedReader;
import java.io.IOException;

public class ReadFileOneLine implements ReadFile {

    @Override
    public String read(BufferedReader bufferedReader) throws IOException {
        return bufferedReader.readLine() + "\n" + bufferedReader.readLine();
    }
}
