package designpatterns.visitor;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        try {
            //和Composite模式中一样的目录结构
            Directory rootdir = new Directory("root");
            Directory bindir = new Directory("bin");
            Directory tmpdir = new Directory("tmp");
            Directory usrdir = new Directory("usr");
            rootdir.addEntry(bindir).addEntry(tmpdir).addEntry(usrdir);
            bindir.addEntry(new File("vi", 10000));
            bindir.addEntry(new File("latex", 20000));
            Directory yukidir = new Directory("yuki");
            Directory hanakodir = new Directory("hanako");
            Directory tomuradir = new Directory("tomura");
            usrdir.addEntry(yukidir).addEntry(hanakodir).addEntry(tomuradir);
            yukidir.addEntry(new File("diary.html", 100));
            yukidir.addEntry(new File("Composite.java", 200));
            hanakodir.addEntry(new File("memo.tex", 300));
            hanakodir.addEntry(new File("index.html", 350));
            tomuradir.addEntry(new File("game.doc", 400));
            File file = new File("iunk.mail", 500);
            tomuradir.addEntry(file);

            //不再使用Entry对象的方法
            //rootdir.printList();

            Visitor visitor = new ListVisitor();

            visitor.visit(rootdir);

            rootdir.accept(visitor);

            System.out.println("============================");

//            FileFindVisitor fileFindVisitor = new FileFindVisitor(".html");
//
//            rootdir.accept(fileFindVisitor);
//
//            for (Iterator<File> it = fileFindVisitor.iterator(); it.hasNext(); ) {
//                System.out.println(it.next());
//            }

//            SizeVisitor sizeVisitor = new SizeVisitor();
//
//            rootdir.accept(sizeVisitor);
//            System.out.println(sizeVisitor.getSize());

            Directory root1 = new Directory("root1");
            root1.addEntry(new File("diary.html", 10));
            root1.addEntry(new File("index.html", 20));

            Directory root2 = new Directory("root2");
            root2.addEntry(new File("diary.html", 1000));
            root2.addEntry(new File("index.html", 2000));

            ElementArrayList elementArrayList = new ElementArrayList();

            elementArrayList.add(root1);
            elementArrayList.add(root2);
            elementArrayList.add(new File("etc.html", 1234));

            elementArrayList.accept(new ListVisitor());


        } catch (FileTreatmentException e) {
            System.out.println(e);
        }
    }
}
