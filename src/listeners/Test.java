package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ServletContext sc = req.getServletContext();
            sc.setAttribute("name", "jenny");
            Thread.sleep(100);

            sc.setAttribute("name2", "cony");
            Thread.sleep(100);

            sc.setAttribute("name", "minko");
            Thread.sleep(100);

            sc.removeAttribute("name");
            Thread.sleep(100);

            resp.setContentType("text/html;charset=UTF-8");
            resp.getWriter().write("<p>设置,更新和删除了ServletContext的属性</p>");
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
