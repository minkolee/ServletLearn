package ajaxlearn;


import java.io.File;
import java.util.Arrays;

public class Print {

    public static void print(Object obj) {
        System.out.print(obj);
    }

    public static void println(Object obj) {
        System.out.println(obj);
    }

    public static void println() {
        System.out.println();
    }

    public static void printArray(Object[] obj) {
        println(Arrays.toString(obj));
    }

    public static void main(String[] args) {
        File file = new File("D:\\Downloads");
        System.out.print(file);

        for (File eachFile : file.listFiles()) {
            String newFileName = eachFile.getName();
            if (eachFile.isDirectory()) {
                if (newFileName.startsWith("第一")) {
                    newFileName = newFileName.replace("第一", "第01");
                    eachFile.renameTo(new File(newFileName));
                } else if (newFileName.startsWith("第二")) {
                    newFileName = newFileName.replace("第二", "第02");
                    eachFile.renameTo(new File(newFileName));
                }else if (newFileName.startsWith("第三")) {
                    newFileName = newFileName.replace("第三", "第03");
                    eachFile.renameTo(new File(newFileName));
                }else if (newFileName.startsWith("第四")) {
                    newFileName = newFileName.replace("第四", "第04");
                    eachFile.renameTo(new File(newFileName));
                }else if (newFileName.startsWith("第五")) {
                    newFileName = newFileName.replace("第五", "第05");
                    eachFile.renameTo(new File(newFileName));
                }else if (newFileName.startsWith("第六")) {
                    newFileName = newFileName.replace("第六", "第06");
                    eachFile.renameTo(new File(newFileName));
                }else if (newFileName.startsWith("第七")) {
                    newFileName = newFileName.replace("第七", "第07");
                    eachFile.renameTo(new File(newFileName));
                }else if (newFileName.startsWith("第八")) {
                    newFileName = newFileName.replace("第八", "第08");
                    eachFile.renameTo(new File(newFileName));
                }else if (newFileName.startsWith("第九")) {
                    newFileName = newFileName.replace("第九", "第09");
                    eachFile.renameTo(new File(newFileName));
                }else if (newFileName.startsWith("第十章")) {
                    newFileName = newFileName.replace("第十章", "第10章");
                    eachFile.renameTo(new File(newFileName));
                }else if (newFileName.startsWith("第十一")) {
                    newFileName = newFileName.replace("第十一", "第11");
                    eachFile.renameTo(new File(newFileName));
                }else if (newFileName.startsWith("第十二")) {
                    newFileName = newFileName.replace("第十二", "第12");
                    eachFile.renameTo(new File(newFileName));
                }else if (newFileName.startsWith("第十三")) {
                    newFileName = newFileName.replace("第十三", "第13");
                    eachFile.renameTo(new File(newFileName));
                }else if (newFileName.startsWith("第十四")) {
                    newFileName = newFileName.replace("第十四", "第14");
                    eachFile.renameTo(new File(newFileName));
                }else if (newFileName.startsWith("第十五")) {
                    newFileName = newFileName.replace("第十五", "第15");
                    eachFile.renameTo(new File(newFileName));
                }
            }
        }
    }
}
