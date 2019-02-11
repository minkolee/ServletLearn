package Base;
import JDBCUtils.Tools;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 get请求需要返回默认的用户登录页面

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 拿到req里 post 过来的用户名和密码数据
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("用户名称: "+name + " 用户密码: " + password);
        //2 连接数据库,去查询用户名和密码,如果查到结果说明登录成功,查不到结果说明登录失败
//        resp.getWriter().write(name);
//        resp.getWriter().write(password);

        Connection conn = null;
        ResultSet rs = null;


        try {
            conn = Tools.getConnection();
            String sql = "select * from users where name=? and password=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setObject(1, name);
            pst.setObject(2, password);
            rs = pst.executeQuery();

            if (rs.next()) {
                resp.setContentType("text/html;charset=utf-8");
                resp.getWriter().println("<h1>您好,登录成功</h1>");


            } else {
                resp.setContentType("text/html;charset=utf-8");
//                resp.getWriter().println("<h1>登录失败</h1>");
                String data = "<h1 style='color:red'>登录失败</h1>";
                OutputStream ps = resp.getOutputStream();
                //这句话的意思，使得放入流的数据是utf8格式
                ps.write(data.getBytes(StandardCharsets.UTF_8));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
