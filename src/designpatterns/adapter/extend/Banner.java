package designpatterns.adapter.extend;

public class Banner {

    private String string;

    public Banner(String string) {
        this.string = string;
    }

    public void showWithParen() {
        System.out.print('(');
        System.out.print(string);
        System.out.println(')');
    }

    public void showWithAster() {
        System.out.print('*');
        System.out.print(string);
        System.out.println('*');
    }
}
