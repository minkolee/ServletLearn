package thinkinginjava.learn.chapter18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * 使用匿名内部类来改进, 而不是将类写在外部, 由于这个类仅会被这个程序使用.
 */

public class DirList2 {

    public static FilenameFilter filter(final String regex) {
        //使用静态方法内部的匿名内部类, 来返回一个filter, 传入final的regex即可得到一个对应的filter
        return new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);

            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };
    }

    public static void main(String[] args) {

        //使用构造器传入路径名, . 表示当前路径
        File path = new File(".");
        //声明一个字符串数组用来存放列出来的文件名
        String[] list;

        //如果目录名没有输入, 装入当前的目录下文件名
        if (args.length == 0) {
            list = path.list();
        }

        else {
            //list接受一个实现了FilenameFilter接口的对象, 会调用其中的accept方法判断list中每一个对象, 只过滤满足条件的内容.
            list = path.list(new DirFilter(args[0]));
        }

        if (list == null) {
            return;
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);

        for (String item : list) {
            System.out.println(item);
        }

        System.out.println("----------------------------");

        File[] files = path.listFiles();

        for (File f : files) {
            System.out.println(f.length());
        }
    }

}

