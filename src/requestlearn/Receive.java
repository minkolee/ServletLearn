package requestlearn;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;

public class Receive extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-----------------------获取请求行数据-------------------------");
        System.out.println(req.getMethod());
        System.out.println(req.getRequestURI());
        System.out.println(req.getRequestURL());
        System.out.println(req.getContextPath());
        System.out.println(req.getQueryString());
        System.out.println(req.getParameter("name"));


        System.out.println("-----------------------Receive Servlet starts-------------------------");
        System.out.println("请求参数列表:");
        Enumeration<String> names = req.getHeaderNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            System.out.println(name + "---" + req.getHeader(name));
        }

        System.out.println("----------------开始获取自定义设置的键值----------------------");
        Enumeration<String> attrs = req.getAttributeNames();
        while (attrs.hasMoreElements()) {
            String attrname = attrs.nextElement();
            System.out.println(attrname + "---" + req.getAttribute(attrname));
        }

        // 修改请求中的数据
        req.setAttribute("custom2", 333);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("这是从Receive写入的程序<br>");

        System.out.println("-----------------------开始获取Cookie-------------------------");

        //打印所有cookie
        Cookie[] cookies;
        cookies = req.getCookies();
        resp.setContentType("text/html;charset=UTF-8");
        for (Cookie c : cookies) {
            System.out.println(c.getName());
            System.out.println(c.getValue());
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
