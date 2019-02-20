<%@ page import="java.util.Random" %>
<%@ page import="java.awt.*" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Minko
  Date: 2019/2/9
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" session="true" errorPage="error.jsp" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>测试JSP</title>
    <style>
        h1 {
            text-align: center;
            color: mediumvioletred;
        }
    </style>

</head>
<body>
<%--声明一些变量和方法--%>
<%! private int i = 0;
    private int z = 99;
    private Random rand = new Random();
    int y = 1 / 0;
    private Connection conn = JDBCUtils.Tools.getConnection();
%>

<% session.setAttribute("name", "gugugu");
    List list = new ArrayList();


%>
<%--用来输出--%>
<h1><%=7777%>
</h1>
<h1><%=77777%>
</h1>
<h1><%=session.getAttribute("name")%>
</h1>


</body>
</html>
