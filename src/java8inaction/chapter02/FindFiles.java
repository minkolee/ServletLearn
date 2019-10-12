package java8inaction.chapter02;

import java.io.File;

public class FindFiles {

    public static void main(String[] args) {

        File[] hiddenFiles = new File("D:\\Downloads").listFiles(File::isHidden);

        for (File file : hiddenFiles) {
            System.out.println(file);
        }
    }
}
