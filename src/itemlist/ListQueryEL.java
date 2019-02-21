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
 * EL表达式,用于在JSP中取值,嵌入到JSP页面的内部,以尽可能少的编写Java代码
 */


public class ListQueryEL extends HttpServlet {
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
        req.setAttribute("attr1","saner");
        Product product = queryAll().get(0);

        req.setAttribute("single", product);

        req.setAttribute("products", queryAll());
        // 转发请求给JSP
        req.getRequestDispatcher("/listel.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }


    //
    private List<Product> queryAll() {
        try {
            String queryAll = "SELECT * FROM product ORDER BY market_price";
            QueryRunner queryRunner = new QueryRunner(source);
            return queryRunner.query(queryAll, new BeanListHandler<Product>(Product.class));
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }

    }



}
