package JDBCUtils;

import java.sql.*;

public class Tools {

    public static Connection getConnection() {
        Connection connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/mydatabase?useSSL=false&useUnicode=true&characterEncoding=UTF-8";
            String user = "root";
            String password = "fflym0709";
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return connection;
    }

    public static void slientCloseAll(Connection connection, PreparedStatement preparedStatement, ResultSet rs) {
        try {
            rs.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("出错了但是不影响运行");
        }
    }
}
