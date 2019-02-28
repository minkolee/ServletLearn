package listeners;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Test2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        //域对象内 存取数据的监听
//        try {
//            ServletContext sc = req.getServletContext();
//            sc.setAttribute("name", "jenny");
//            Thread.sleep(1000);
//
//            sc.setAttribute("name2", "cony");
//            Thread.sleep(1000);
//
//            sc.setAttribute("name", "minko");
//            Thread.sleep(1000);
//
//            sc.removeAttribute("name");
//            Thread.sleep(1000);
//
//            resp.getWriter().write("<p>设置,更新和删除了ServletContext的属性</p>");
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            throw new RuntimeException(ex);
//        }

        // session 存取数据的监听
        HttpSession hs = req.getSession();
        hs.removeAttribute("name");
        hs.setAttribute("name2","cony");
        resp.getWriter().write("session删除了name=jenny");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
