package itemlist;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

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
        // 传对象列表
        req.setAttribute("products", queryAll());
        // 传单个对象
        req.setAttribute("product",queryAll().get(0));

        //传复杂数据结构

        Product product1 = new Product();
        product1.setCid("3");
        product1.setIs_hot(11);
        product1.setMarket_price(999);
        product1.setShop_price(66);
        product1.setPid("32");

        Product product2 = new Product();
        product2.setCid("6");
        product2.setIs_hot(22);
        product2.setMarket_price(123999);
        product2.setShop_price(33);
        product2.setPid("58");



        HashMap<String, Product> innermap = new HashMap<>();

        innermap.put("product1", product1);
        innermap.put("product2", product2);

        HashMap<Product, HashMap<String, Product>> map = new HashMap<>();

        map.put(product1, innermap);

        req.setAttribute("complex", map);

        // 遍历一下复杂对象看看
//        for (HashMap.Entry<Product,HashMap<String,Product>> entry : map.entrySet()) {
//            HashMap<String, Product> map2 = entry.getValue();
//            for (HashMap.Entry<String, Product> entry1 : map2.entrySet()) {
//                System.out.println(entry1.getKey());
//                System.out.println(entry1.getValue());
//            }
//        }

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
