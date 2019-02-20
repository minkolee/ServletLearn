package JSPLearn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * JSP 其实是一个Servlet,其中的不同标注的部分,会看是否放到service方法里还是之外
 * 1）<%java代码%> 这个会被放到service方法里边执行
 * 2）<%=java变量或表达式> 这个会被放到service里的 out.print()里做为输出
 * 3）<%!java代码%> 会变成servlet成员对象的内容,可以定义变量和方法
 *
 * 另外还有9个对象,用于取得这个Servlet的方方面面,方便在页面内操作
 * 所以一般的操作就是,当页面的变量放入<%! %>之内, 业务处理放在<% %>之内,最后输出的内容在页面的<%= %>中进行处理</%>
 *
 *
 *
 *
 *
 * Page指令,代表的是JSP页面运行的一个配置环境,是一些键值对:
 * 其实pageEncoding就可以覆盖contentType的内容
 *
 * 写了这个之后,可以在脚本内直接使用session对象
 * session = "true"
 *
 * extends = 可以设置继承那个类,但是只能继承servlet类
 *
 *
 *
 *
 *
 *
 *
 */

public class JspDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
