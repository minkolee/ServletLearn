package listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class MyRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("------------有请求结束了-------------");

    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("------------请求开始了--------------");
        HttpServletRequest request =(HttpServletRequest) sre.getServletRequest();
        request.setAttribute("name", "from listener");

    }
}
