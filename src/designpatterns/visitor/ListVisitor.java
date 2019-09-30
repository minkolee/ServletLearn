package designpatterns.visitor;


import java.util.Iterator;

public class ListVisitor extends Visitor {

    public String currentdir = "";

    @Override
    public void visit(File file) {
        System.out.println(currentdir + "/" + file);
    }

    @Override
    public void visit(Directory directory) {
        System.out.println(currentdir + "/" + directory);
        String savedir = currentdir;

        currentdir = currentdir + "/" + directory.getName();
        //这是递归调用, 即访问一个Entry目录, 就可以遍历的访问. 这里实际上是Composite模式的应用.
        Iterator<Entry> iterator = directory.iterator();
        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            entry.accept(this);
        }
        currentdir = savedir;
    }
}
