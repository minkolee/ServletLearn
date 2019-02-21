<%@ page import="itemlist.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Minko
  Date: 2019-02-21
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    private StringBuffer rowString(Product product) {
        StringBuffer strings = new StringBuffer();
        strings.append("<tr>");
        strings.append("<td>");
        strings.append(product.getPid());
        strings.append("</td>");
        strings.append("<td>");
        strings.append(product.getPname());
        strings.append("</td>");
        strings.append("<td>");
        strings.append(product.getMarket_price());
        strings.append("</td>");
        strings.append("<td>");
        strings.append(product.getShop_price());
        strings.append("</td>");
        strings.append("<td>");
        strings.append(product.getPimage());
        strings.append("</td>");
        strings.append("<td>");
        strings.append(product.getPdate());
        strings.append("</td>");
        strings.append("<td>");
        strings.append(product.getIs_hot());
        strings.append("</td>");
        strings.append("<td>");
        strings.append(product.getPdesc());
        strings.append("</td>");
        strings.append("<td>");
        strings.append(product.getPflag());
        strings.append("</td>");
        strings.append("<td>");
        strings.append(product.getCid());
        strings.append("</td>");
        strings.append("</tr>");
        return strings;
    }
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


<div class="container-fluid">
    <h1>商品列表</h1>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">id</th>
            <th scope="col">商品名称</th>
            <th scope="col">市场价格</th>
            <th scope="col">商城价格</th>
            <th scope="col">图片地址</th>
            <th scope="col">日期</th>
            <th scope="col">热度</th>
            <th scope="col">商品描述</th>
            <th scope="col">FLAG</th>
            <th scope="col">CID</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Product> lists = (List<Product>) request.getAttribute("products");
            for (Product p : lists) {
                pageContext.getOut().print(rowString(p));
            }
        %>
        </tbody>
    </table>
</div>


</body>
</html>
