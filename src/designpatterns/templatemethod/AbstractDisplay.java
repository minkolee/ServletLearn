package designpatterns.templatemethod;

public abstract class AbstractDisplay {

    //三个抽象方法
    protected abstract void open();
    protected abstract void print();
    protected abstract void close();

    //规定好的操作流程
    public final void display(){
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    };
}
