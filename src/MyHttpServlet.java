import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 就像python的框架一样,也有request和response对象,可以调用各种方法获取想要的信息
 * HttpServlet里的service方法调用的就是doGet和doPost方法,根据请求种类执行对应的代码
 * 这样重点就变成了如何生成HTML,当然可以使用字符串,但是实际上还是可以使用模板了
 *
 * */


public class MyHttpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
