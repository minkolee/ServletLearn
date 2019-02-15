package CookieLearn;

/**
 * Cookie就是服务器让浏览器保存在客户端的数据,由键值对组成
 * 响应头里Set-Cookie然后加上数据,浏览器看到这个,就会保存cookie
 * Cookie键值对中间由一个分号加一个空格隔开
 * 可见,第一次进来的时候,附加上了Cookie信息,但是进来的请求还没有附带上
 * 第二次请求进来的时候,就附带上了cookie信息
 *
 */

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Cookie的基本使用
        System.out.println("CookieDemo启动");
        // 1 先创建一个Cookie对象,
        Cookie cookie = new Cookie("location2","恐龙园");
        resp.addCookie(cookie);

        Cookie[] cookies;
        cookies = req.getCookies();

        for (Cookie c : cookies) {
            System.out.println(c.getName()+'|'+c.getValue());
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
