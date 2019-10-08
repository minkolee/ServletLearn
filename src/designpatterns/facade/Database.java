package designpatterns.facade;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Database {

    private Database() {

    }

    public static Properties getProperties(String name) {
        String filename = name + ".txt";
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(filename));

        } catch (IOException e) {
            System.out.println("加载文件失败");
        }
        return properties;
    }

}
