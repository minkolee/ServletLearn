package requestlearn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class ReqLearn extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //HTTP请求有请求行,请求头和体,请求行最前边是请求方式,这些都可以获得,尤其是请求头的键值对,还有请求体尤其是POST请求的内容

        //-----------------------------请求行的内容-----------------------------------
        // 获得请求方式req.getMethod
        System.out.println(req.getMethod());
        //获取地址
        System.out.println(req.getRequestURI());
        //获取URL,这是一个StringBuffer对象
        StringBuffer url = req.getRequestURL();
        System.out.println(url);

        //获得web应用的名称,就是项目设置的路径名称,就是deployment里边的Application context
        String contextPath = req.getContextPath();
        System.out.println("Web应用的名称是"+contextPath);

        //获取附带的请求参字符串
        System.out.println(req.getQueryString());

        //获取客户端的信息--IP地址,主机名称,来自端口,一般只有IP地址有用
        System.out.println(req.getRemoteAddr());
        System.out.println(req.getRemoteHost());
        System.out.println(req.getRemotePort());

        //-----------------------------请求头的内容-----------------------------------
        System.out.println("------------------------------------------以下是请求头内容---------------------------------------------");
        // 获得所有头的名字,封装到Enum对象中,可以遍历(Enum对象比较老了)
        // 注意,没有cache control 头
        printHeaderContent(req);


        //如果有重复的头,将其内容封装到一个Enum对象中
        Enumeration<String> headers = req.getHeaders("accept-language");


        //获得指定的头
        req.getHeader("Accept-Language");


        // request对象还是一个域对象,也具有setAttribute 和 getAttribute 和 removeAttribute
        // 请求对象在返回响应之后就销毁了,那么为什么要使用request对象作为域对象呢,主要就是可以进行请求转发,转发的请求可以通过这个携带额外的数据
        // 注意,转发请求并不是重定向,因为重定向返回了响应给客户端,而请求转发是直接转发请求给另外一个servelet

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // post 同样可以获取请求头
        System.out.println("----------------------------------POST请求-----------------------------");

        printHeaderContent(req);

        //Post请求,可以获取请求体
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        System.out.println(password);

        //还有几个方法,这个也是封装的Enumeration中的所有请求体的键名
        req.getParameterNames();

        //这个很重要,用于获取POST的多个数据,比如复选框
        String[] strings = req.getParameterValues("hobby");
        for (String s : strings) {
            System.out.println(s);
        }
    }

    private void printHeaderContent(HttpServletRequest req) {
        Enumeration<String> names = req.getHeaderNames();
        while (names.hasMoreElements()) {
            String headerKey = names.nextElement();

            //获得指定的头,开发中最常用的就是这个方法,一般复杂的Web应用要操作HTTP头部信息
            String headercontent = req.getHeader(headerKey);
            System.out.println(headerKey + " : " + headercontent);
            //一般HTTP 的POst 请求有referrer头,可以据此判断来源
//            除非在浏览器的地址栏内直接输入,没有referer头,通过链接访问,就带referer头,所以可以防止盗链
        }
    }

}