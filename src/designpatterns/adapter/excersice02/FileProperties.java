package designpatterns.adapter.excersice02;

import java.io.*;
import java.util.Properties;

public class FileProperties implements FileIO {

    Properties properties = new Properties();

    @Override
    public void readFromFile(String filename) throws IOException {
        properties.load(new BufferedReader(new FileReader("file.txt")));
    }

    @Override
    public void writeToFile(String filename) throws IOException {
        properties.store(new PrintWriter(filename), "written by FileProperties");

    }

    @Override
    public void setValue(String key, String value) {
        properties.setProperty(key, value);
    }

    @Override
    public String getValue(String key) {
        return properties.getProperty(key);
    }
}
