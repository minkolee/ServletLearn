package Register;

/**
 * 用户注册功能
 * 1 写一个JSP页面,用于用户post数据进来,而get路径,就需要返回该页面
 * <p>
 * 2 分几种情况
 * --如果用户注册成功,则需要返回注册成功信息
 * --如果用户填写的部分字段有误,则需要返回用户哪里有错误并且提醒用户,
 * <p>
 * <p>
 * 先来进行获取表单数据
 * <p>
 * 设计了一个用户表,里边有uuid作为用户id,还有用户名,密码和电子邮件
 */

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get请求重定向到index.jsp
        resp.sendRedirect("index.jsp");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // -------------------1 获取用户Post进来的数据,封装成user对象

        //最好将对象封装到一个Users名称的bean类中
        //但是逐个获取再使用set方法太麻烦,所以使用一个第三方库,通过req.getParameterMap()生成的map集合来将数据封装到对象中
        //使用BeanUtils进行自动的封装
        User user = new User();
        try {

            BeanUtils.populate(user, req.getParameterMap());
        } catch (Exception ex) {
            System.out.println("--------------------出现异常----------------------");
            ex.printStackTrace();
            System.out.println("------------------异常信息结束---------------------");
        }
        // 注意,此时只有三个参数,uid还没有着落,如果此时去获取,可以发现为null
        // 手工封装UID,使用UUID工具,就是一个随机不重复的32位字符串,生成后变成36位,所以在数据库里留够空间
        user.setUid(UUID.randomUUID().toString());

        // -------------------2 调用操作数据库写入post数据的方法--------

        //可以自行封装一个方法来调用,使用JDBC
        resp.setContentType("text/html;charset=UTF-8");

        if (regist(user)) {
            resp.getWriter().write("成功注册");
        } else {
            resp.getWriter().write("注册失败");
        }

        resp.setHeader("refresh","5;url=index.jsp");

    }


    private boolean regist(User user) {
        boolean flag = false;
        Connection conn = JDBCUtils.Tools.getConnection();

        String sqluser = "SELECT username FROM users where username=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sqluser);
            pst.setString(1, user.getUsername());
            ResultSet resultSet = pst.executeQuery();
            if (resultSet.next()) {
                return false;
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        String query = "INSERT INTO users values (?,?,?,?)";

        try {
            PreparedStatement pst = conn.prepareStatement("INSERT INTO users values (?,?,?,?)");
            pst.setString(1, user.getUid());
            pst.setString(2, user.getUsername());
            pst.setString(3, user.getPassword());
            pst.setString(4, user.getEmail());
            pst.execute();
            flag = true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return flag;
    }
}
