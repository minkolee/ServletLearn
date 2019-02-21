<%--
  Created by IntelliJ IDEA.
  User: Minko
  Date: 2019/2/9
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="UTF-8">
    <title>用户登录</title>
  </head>
  <body>
  <h1 style="text-align: center;">用户注册</h1>
  <div class="wrapper">
    <form action="register" method="post">
      <label>Name
        <input type="text" name="username">
      </label>
      <label>Password
        <input type="password" name="password">
      </label>
      <label>Email
        <input type="email" name="email">
      </label>
      <input type="submit">
    </form>
  </div>

  <%=request.getAttribute("name")%>

  </body>
</html>
