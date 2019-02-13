package Register;

/**
 * 用户注册功能
 * 1 写一个JSP页面,用于用户post数据进来,而get路径,就需要返回该页面
 *
 * 2 分几种情况
 * --如果用户注册成功,则需要返回注册成功信息
 * --如果用户填写的部分字段有误,则需要返回用户哪里有错误并且提醒用户,
 *
 *
 * 先来进行获取表单数据
 *
 *
 *
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get请求重定向到index.jsp
        resp.sendRedirect("index.jsp");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取值,可以发现中文乱码,需要解决
        //关键是要知道浏览器是以什么样的编码Post过来的数据,不能直接转换字符串
        String name = new String(req.getParameter("username").getBytes("UTF-8"), StandardCharsets.UTF_8);


        String password = req.getParameter("password");
        String email = req.getParameter("email");
        System.out.println(name + '|' + password + '|' + email);
        resp.sendRedirect("index.jsp");

    }
}
