package designpatterns.adapter.excersice02;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        FileIO f = new FileProperties();
        try {
            f.readFromFile("file.txt");
            f.setValue("year", "2014");
            f.setValue("month", "6");
            f.setValue("day", "29");
            f.writeToFile("newfile.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
