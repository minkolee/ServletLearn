package designpatterns.composite;

import designpatterns.builder.Director;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Making entries...");
            Directory rootdir = new Directory("root");
            Directory bindir = new Directory("bin");
            Directory tmpdir = new Directory("tmp");
            Directory usrdir = new Directory("usr");

            rootdir.addEntry(bindir).addEntry(tmpdir).addEntry(usrdir);

            System.out.println(usrdir.getAbsoultePath());

            bindir.addEntry(new File("vi", 10000));
            bindir.addEntry(new File("latex", 20000));


            Directory yukidir = new Directory("yuki");
            Directory hanakodir = new Directory("hanako");
            Directory tomuradir = new Directory("tomura");

            usrdir.addEntry(yukidir).addEntry(hanakodir).addEntry(tomuradir);

            yukidir.addEntry(new File("diary.html", 100));
            yukidir.addEntry(new File("Composite.java", 200));

            hanakodir.addEntry(new File("memo.tex", 300));

            tomuradir.addEntry(new File("game.doc", 400));

            File file = new File("iunk.mail", 500);
            tomuradir.addEntry(file);

            rootdir.printList();

            System.out.println("=======================================");

            System.out.println(hanakodir.getAbsoultePath());
            System.out.println(tomuradir.getAbsoultePath());
            System.out.println(file.getAbsoultePath());
        } catch (FileTreatmentException e) {
            System.out.println(e);
        }
    }
}
