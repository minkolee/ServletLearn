package designpatterns.visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileFindVisitor extends Visitor {

    private String suffix;

    private List<File> files = new ArrayList<>();


    public FileFindVisitor(String suffix) {
        this.suffix = suffix;
    }

    //访问到文件的时候, 将文件记录到数组中
    @Override
    public void visit(File file) {
        if (file.getName().endsWith(suffix)) {
            files.add(file);
        }
    }

    //访问的如果是目录, 对其递归的调用所有的方法
    @Override
    public void visit(Directory directory) {

        Iterator<Entry> entryIterator = directory.iterator();
        while (entryIterator.hasNext()) {
            entryIterator.next().accept(this);
        }
    }

    public Iterator<File> iterator() {
        return files.iterator();
    }
}
