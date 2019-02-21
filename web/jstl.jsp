<%@ page import="itemlist.Good" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Minko
  Date: 2019-02-21
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%--导入JSTL的核心库--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%!
    private StringBuffer rowString(Good good) {
        StringBuffer strings = new StringBuffer();
        strings.append("<tr>");
        strings.append("<td>");
        strings.append(good.getId());
        strings.append("</td>");
        strings.append("<td>");
        strings.append(good.getName());
        strings.append("</td>");
        strings.append("<td>");
        strings.append(good.getQuantity());
        strings.append("</td>");
        strings.append("</tr>");
        return strings;
    }
%>

<%
    request.setAttribute("count", 3);
%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <title>商品列表</title>
    <style>
        h1 {
            text-align: center;
            color: mediumvioletred;
        }
    </style>
</head>
<body>
<%--使用JSP的import指令导入JSTL,看上边的指令--%>

<%--c:if标签,test表示返回boolean的一个表达式--%>
<%--借助于EL表达式的值进行判断--%>
<c:if test="${1==1}">这是JSTL标签if为真的地方</c:if>
<c:if test="${1!=1}">这是JSTL标签if为假的地方</c:if>
<%--if标签经常和EL配合使用,以在取数的时候进行判断然后显示--%>
<%--if标签没有else功能,所以通常要把else判断或者elif判断的条件写一排--%>
<c:if test="${requestScope.count>=10}">count大于等于10</c:if>
<c:if test="${requestScope.count<10}">count小于10</c:if>

<%--foreach标签的用法--%>

<%--第一种,模拟 for(int i= 0;i<n;i++) 这种循环, 这个变量被设置在Page域上,配合EL就可以当做字符来使用,非常方便--%>
<c:forEach begin="0" end="5" var="i"><h3>${pageScope.i}</h3></c:forEach>

<%--第二种,模拟增强for循环: for(Good x: List y)--%>
<%--这里的var代表集合中的一个元素,这个var的名称也是被放到page域的--%>
<c:forEach items="${products}" var="good"><span style="color:red">${good.name}</span><br><span style="color:green">${good.quantity}</span><br></c:forEach>
<%--注意items="${products}" 不能加空格,EL表达式里边可以有空格,但是外边不能有,items="${products} "会报错--%>

<div class="container">
    <h1>商品列表</h1>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">id</th>
            <th scope="col">商品名称</th>
            <th scope="col">数量</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Good> lists = (List<Good>) request.getAttribute("products");
            for (Good g : lists) {
                pageContext.getOut().print(rowString(g));
            }
        %>
        </tbody>
    </table>
</div>


</body>
</html>
