package designpatterns.chain;


public abstract class Support {

    private String name;

    private Support next;

    public Support(String name) {
        this.name = name;
    }

    public Support setNext(Support next) {
        this.next = next;
        return next;
    }

    //这是一种模板模式, 即算法在抽象类中规定好了.
    //这里先尝试用当前对象进行解决问题, 如果不行, 就将其交给下一个对象
    public final void support(Trouble trouble) {
        if (resolve(trouble)) {
            done(trouble);
        } else if (next != null) {
            next.support(trouble);
        } else {
            fail(trouble);
        }
    }

    protected abstract boolean resolve(Trouble trouble);

    protected void done(Trouble trouble) {
        System.out.println(trouble + " is resolved by " + this);
    }

    protected void fail(Trouble trouble) {
        System.out.println("No Supporter can resolve " + trouble);
    }

    @Override
    public String toString() {
        return "Support{" +
                "name='" + name + '\'' +
                '}';
    }
}
