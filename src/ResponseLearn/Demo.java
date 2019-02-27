package ResponseLearn;

/**
 * 头部可以自定义
 * addHeader用于添加,同一个键多次添加,值会加成一个长字符串
 * setHeader用于设置,会将键设置为指定的值
 * 还可以修改一些特定的头部信息,用于让浏览器做一些解释和动作
 * 比常用的有重定向
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



public class Demo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置状态码
//        resp.setStatus(200);
//        resp.addDateHeader("Date", System.currentTimeMillis() * 2);
        // 设置自定义头部
//        resp.addIntHeader("Name",6666);
//        resp.setHeader("Name", "9999");
//        resp.addHeader("Custom", "jenny");
//        resp.addHeader("Custom","cony");
        //add设置已经存在的头部,会将内容加上去,长度小于实际内容会造成浏览器只接受指定长度的内容,这个还是交给HTTP代理比较好
//        resp.setHeader("Content-Length", "2");
        //最关键的,设置编码,要设置编码之后再写入内容.JSP文件也要设置相应的编码给浏览器
        // set是修改原来的内容

        //设置跳转302响应

//        resp.setStatus(302);
//        resp.setHeader("location","/download");

        //设置定时跳转


        //重定向的简单做法
        resp.sendRedirect("http://www.sina.com.cn");










        resp.setContentType("text/html;charset=UTF-8");
        //这是字符流,还一个字节流,但是注意,一个请求的输出IO流只能被调用一次,也就是说可以反复调用字节流或者字符流的write,但不能先调用字节流的write再调用字符流的write
//        resp.getWriter().write("生化危机2 RE 专家模式还是不容易的");
//        resp.getOutputStream().write(67);
//        resp.getOutputStream().write(109);




    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
