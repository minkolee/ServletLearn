import JDBCUtils.Tools;

import javax.servlet.ServletContext;
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

/**
 * ServletContext对象,是一个web应用的环境上下文的对象,通过这个可以在不同的servlet类之间共享数据
 * 获得该对象的方法:
 * 1 init方法里 ServeletContext sc = config.getServletContext()
 * 2 this.getServletContext(),这个随时随地可以获得,只要Web应用跑起来,这个Web应用里获得的都是同一个对象
 * 类似map,用 setAttribute 存入 键和值,用 getAttribute取出键和值
 *
 *
 * 还有一个重要应用是获得Web应用内所有资源的路径
 *
 *
 */


public class LoginCountUseServletContext2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 get请求需要返回默认的用户登录页面
        Long count = (long) (this.getServletContext().getAttribute("count")) + 1;
        this.getServletContext().setAttribute("count", count);
        System.out.println(this.getServletContext().getAttribute("count"));
    }





}
