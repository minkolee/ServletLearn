package listeners;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MyServletContextAttrListener implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        System.out.println("--------------有属性被添加了-------------");
        System.out.println("-----" + scae.getName() + " | " + scae.getValue());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        // 注意,这里获得是删除的值,不是更新的值
        // 更新的值需要通过getAttribute方法获取
        System.out.println("--------------有属性被删除了-------------");
        System.out.println("-----" + scae.getName() + " | " + scae.getValue());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        System.out.println("--------------有属性被修改了-------------");
        System.out.println("-----" + scae.getName() + " | " + scae.getValue());
        System.out.println("--------------更新的值-------------");
        System.out.println("-----" + scae.getName() + " | " + scae.getServletContext().getAttribute(scae.getName()));
    }
}


