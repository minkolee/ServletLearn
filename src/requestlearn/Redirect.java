package requestlearn;

/**
 * 用这个servlet 将 请求转发到 Receive Servlet,来看看自行添加的数据是否可以取得
 *
 * 通过测试可以发现,
 * Redirect接到请求并设置数据---转发给Receive----Receive接收到请求和响应,请求可以设置数据和读取数据(转发的时候还加上了新的几个头表示转发)
 * Receive写入响应,执行完毕之后--- Redirect 再执行剩余代码,但是请求已经无法更改,因为这是转发,请求会由另外一个Servelet直接发送回服务器
 * Request对象的生命周期是一次请求到一次响应,响应发送之后请求和响应对象都销毁了
 *
 * include是请求包含,基本上不用
 * 转发的性能要优于重定向
 * 转发由于是内部,无需写项目名称(本项目为了学习使用了空的application context),重定向需要,由于是浏览器从外部访问
 *
 */

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class Redirect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-----------------------转发请求开始-------------------------");
        System.out.println("请求参数列表:");
        Enumeration<String> names = req.getHeaderNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            System.out.println(name + "---" + req.getHeader(name));
        }

        System.out.println("-------开始设置request对象的参数并且进行请求转发--------");
        req.setAttribute("custom1", "test1");
        req.setAttribute("custom2", 22);
        req.setAttribute("custom3", '3');

        // 创建请求转发对象
        RequestDispatcher dispatcher = req.getRequestDispatcher("receive");
        dispatcher.forward(req, resp);
        // ---------------------------------转发完成之后还要回来,然后再执行原来的servlet之后的代码--------------------------------------
        //转发之后的代码在转发结束之后再执行,看一看能否获取修改之后的键值对
        System.out.println(req.getAttribute("custom2"));

        //再向resp里写入一些东西,看看到底返回了什么
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("这是从Redirect写入的数据<br>");
        //发现不能再写入了,只返回了Receive返回的内容



        System.out.println("-----------------------转发请求结束-------------------------");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
