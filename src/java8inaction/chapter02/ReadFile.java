package java8inaction.chapter02;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface ReadFile {

    String read(BufferedReader bufferedReader) throws IOException;

}
