package SessionLearn;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Session的实现是基于Cookie，Session需要借助于Cookie存储客户的唯一性标识JSESSIONID
 * 获得Session对象 HttpSession session = req.getSession();
 * 注意,设置了之后,就会在Cookie中设置一个JSESSIONID,靠这个来识别
 *
 * 实现了一个简单的访问一个链接写入一个数据,再访问另外一个链接从session里读出来的功能
 * 说明会话中session一直存在
 * 之后再访问,就一直发现session 的数据还在
 * Session的生命周期
 * 服务器重启就会结束
 * Session 一般30分钟就结束,从不操作服务器的资源开始计算
 * 可以在Web.xml中进行配置
 * 但是经过试验,由于默认情况下,浏览器关闭之后,cookie就清空,无法持久化JSESSIONID
 * 所以要想办法持久化
 *
 *
 */

public class SessionDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String name = (String) session.getAttribute("name");
        System.out.println(name);

        System.out.println(session.getId());
        //可以手动销毁
//        session.invalidate();
        //销毁完再访问就没有数据了
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
