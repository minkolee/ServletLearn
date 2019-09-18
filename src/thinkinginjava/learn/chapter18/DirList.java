package thinkinginjava.learn.chapter18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList {

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
    }

}

//过滤文件名的类, 根据正则过滤
class DirFilter implements FilenameFilter {
    private Pattern pattern;

    DirFilter(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}