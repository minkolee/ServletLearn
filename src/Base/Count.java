package Base;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**

 *
 */


public class Count extends HttpServlet {

    private ServletContext servletContext = this.getServletContext();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(servletContext.getAttribute("count"));
//        Long count = (long) (servletContext.getAttribute("count")) + 1;
//        servletContext.setAttribute("count", count);
//        System.out.print("当前全局变量的统计数字是: ");
//        System.out.println(servletContext.getAttribute("count"));

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }



}
