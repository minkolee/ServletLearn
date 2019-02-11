package Base;
import javax.servlet.*;
import java.io.IOException;

/**
 * 实际操作的时候,不太会去实现Servlet接口,因为要覆盖和重现编写的方法太多
 * 而是继承HttpServlet类,然后重写 doGet 和 doPost方法,这样就能够针对Tomcat引擎封装的get和post请求对象进行操作
 * 每次的request和response对象都在访问时创建,在结束时候销毁
 *
 *  url-pattern的配置方式
 *  1
 *  <url-pattern>/test/1</url-pattern>
 *  直接写,叫做完全匹配,必须完全匹配才行
 *
 *  2 目录匹配
 *
 *  <url-pattern>/test/*</url-pattern>
 *  test之下和test本身都可以匹配
 *
 *  3 扩展名匹配
 *  <url-pattern>*.pdc</url-pattern>
 *  有了这些就可以自定义url了
 *  注意第二种和第三种不要混用 ,比如 aa/bb/cc/*.abcd ,会报错
 *
 *  Servlet默认第一次访问时候创建,如果加上一个配置 load-on-startup , 那这个服务器启动的时候就会被创建,而不是第一次访问的时候就创建
 *  url pattern 配成一个 / 的时候,如果全部不匹配,就找这个对应的类执行
 *
 *  tomcat的web.xml是全局的,自己的配置会覆盖全局的,如果找不到再找全局的
 *  静态资源的寻找也是由servlet负责
 *
 *  在web.xml里不配置welcome-list的时候,也会自动去找默认的配置
 *  欢迎页面可以单独配置,如果自己不配置,全局里也有,会找默认的index.html index.jsp之类的文件
 *
 *
 *
 */

public class test implements Servlet {


//    第一次访问,创建对象的时候执行
//    这其中的Servelet config 是该对象的配置对象
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        // 这个
        System.out.println(servletConfig.getServletName()); // 这个就是配置里的<servlet-name>firstcontact</servlet-name> ,一般在封装框架的时候使用,单独没有什么用处,就是一个标识
        System.out.println(servletConfig.getInitParameterNames()); // 获得初始化配置
        System.out.println(servletConfig.getInitParameter("url")); // 获得初始化对象
        // 还能够获得ServeletContext对象,会单独学习


    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    // 每次访问的时候执行
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("成功进行一次访问");

    }

    @Override
    public String getServletInfo() {
        return null;
    }

//    直到服务器运行关闭的时候,会出现销毁函数执行的样子
    @Override
    public void destroy() {
        System.out.println("销毁函数");

    }
}
