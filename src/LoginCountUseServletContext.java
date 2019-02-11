import JDBCUtils.Tools;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
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
 *
 * 自己试验的结果,让一个servlet对象随web应用启动,然后在init里对上下文对象设置好想要的初始值
 *
 * 然后其他的东西再去访问,让数据共享操作还是比较麻烦的.
 *
 */


public class LoginCountUseServletContext extends HttpServlet {

    // 这里由于配置了初始化就创建servlet对象,所以会有初始的count值,假如不在服务器启动的时候就创建servlet对象,则如果用add1路径去增加,就会报空指针


    @Override
    public void init() throws ServletException {
//
        this.getServletContext().setAttribute("count", 0L);
    }

    private String addCount() {
//        设置和获取上下文变量中的键值对
        Long count = (long) (this.getServletContext().getAttribute("count")) + 1;
        this.getServletContext().setAttribute("count", count);
        System.out.print("当前全局变量的统计数字是: ");
        System.out.println(this.getServletContext().getAttribute("count"));

        //可以获得XML配置文件中的初始化参数
        System.out.println("获取的XML配置文件中的参数是:"+ this.getServletContext().getInitParameter("driver"));
        System.out.println("获取的XML配置文件中的参数是:" + this.getServletContext().getInitParameter("mywife"));


        // 获取路径,获取路径是为了可以获取对应的文件资源,用于上传下载或者程序中修改文件
        //在不同的路径之下创建了不同的abcd四个txt文件,看如何获取路径,实际上就是了解web容器的目录
        // a.txt 和 WEB-INF同级


        // a 在web容器的根目录下
        String path = this.getServletContext().getRealPath("/a.txt");
        System.out.println(path);


        //WEB-INF不能通过浏览器之间访问,只能通过内部程序


        //b在web-inf下边,发布时候的路径也是这里
        path = this.getServletContext().getRealPath("/WEB-INF/b.txt");
        System.out.println(path);


        // c 要注意,在src下边,但是发布的时候,是在web-inf的类目录下边
        path = this.getServletContext().getRealPath("/WEB-INF/classes/c.txt");
        System.out.println(path);



//        如果要加载classes目录下边的文件c.txt,就用当前的类来加载,然后同样可以获得该地址
        // getresource是相对classes目录
        String url = LoginCountUseServletContext.class.getClassLoader().getResource("c.txt").getPath();
        System.out.println(url);

        // d.txt d根本没有发布到Web目录内,所以获取不到的

        return "您是第<span style='color:red'>" + count + "</span>位登录的用户.";
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 get请求需要返回默认的用户登录页面
        doPost(req,resp);
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
                resp.getWriter().println(addCount());

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
