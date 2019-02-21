package itemlist;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 使用JSTL的时候需要先导包
 * 也是由apache提供的JSTL
 *
 *
 *
 *
 */

public class JSTLDemo extends HttpServlet {
    //servlet初始化的时候设置好连接池

    private static BasicDataSource source = new BasicDataSource();

    @Override
    public void init() {
        source.setDriverClassName("com.mysql.jdbc.Driver");
        source.setUrl("jdbc:mysql://localhost:3306/mydatabase?useSSL=false&useUnicode=true&characterEncoding=UTF-8");
        source.setUsername("root");
        source.setPassword("fflym0709");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 在请求上设置查询结果
        resp.setContentType("text/html;charset=UTF-8");

        // 多设置几种东西传给下一个

        req.setAttribute("products", queryAll());
        // 转发请求给JSP
        req.getRequestDispatcher("/jstl.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }


    private List<Good> queryAll() {
        try {
            String queryAll = "SELECT * FROM goods";
            QueryRunner queryRunner = new QueryRunner(source);
            return queryRunner.query(queryAll, new BeanListHandler<Good>(Good.class));
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }

    }


}
