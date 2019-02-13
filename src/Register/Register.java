package Register;

/**
 * 用户注册功能
 * 1 写一个JSP页面,用于用户post数据进来,而get路径,就需要返回该页面
 *
 * 2 分几种情况
 * --如果用户注册成功,则需要返回注册成功信息
 * --如果用户填写的部分字段有误,则需要返回用户哪里有错误并且提醒用户,
 *
 *
 *
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }
}
