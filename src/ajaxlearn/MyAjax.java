package ajaxlearn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyAjax extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("这是Ajax 请求的Hello");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String user = req.getParameter("username");
        String pwd = req.getParameter("password");
        String email = req.getParameter("email");
        System.out.println(user);
        System.out.println(pwd);
        System.out.println(email);

        String out = user + '|' + pwd + '|' + email;
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write(out);

    }
}
