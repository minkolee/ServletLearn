<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: Minko
  Date: 2019/2/19
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" session="false" %>
<html>
<head>
    <title>测试JSP页面</title>
    <style>
        h1 {
            text-align: center;
            color: mediumvioletred;
        }
    </style>


</head>
<body>
<%
    request.setAttribute("name","jenny");
%>



<jsp:forward page="index.jsp" />

<%!
    private int getRand100() {
        return new Random().nextInt(100);
    }
%>


<h1><%="这是测试页面,会有随机数字"+getRand100()%></h1>




</body>
</html>
