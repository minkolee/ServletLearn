package listeners;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User implements HttpSessionBindingListener {
    private String name;

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("被绑定了");

    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("解绑了");
    }

    User(String name) {
        this.name = name;
    }
}
