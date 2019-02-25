<%--
  Created by IntelliJ IDEA.
  User: Minko
  Date: 2019-02-25
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <title>AJAX请求测试</title>
</head>
<body>

<h1>AJAX请求</h1>

<button id="ajax1">发送AJAX GET请求</button>
<button id="ajax2">发送AJAX POST请求</button>

<p id="result"></p>


<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
    var ajax1 = document.getElementById("ajax1");
    var ajax2 = document.getElementById("ajax2");

    ajax1.addEventListener("click", handler);
    ajax2.addEventListener("click", handler2);

    function handler() {
        document.getElementById("result").innerText = "";
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function (ev) {
            if (xmlhttp.readyState === 4) {
                if (xmlhttp.status === 200) {
                    document.getElementById("result").innerText = xmlhttp.responseText;
                }
            }
        };
        xmlhttp.open("GET", "/ajaxhello");
        xmlhttp.send();
    }


    function handler2() {
        document.getElementById("result").innerText = "";
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function (ev) {
            if (xmlhttp.readyState === 4) {
                if (xmlhttp.status === 200) {
                    document.getElementById("result").innerText = xmlhttp.responseText;
                }
            }
        };
        xmlhttp.open("POST", "/ajaxhello");
        xmlhttp.setRequestHeader("content-type", "application/x-www-form-urlencoded");
        xmlhttp.send("username=cony&password=1234&email=www.conyli.cc");
    }


</script>
</body>
</html>
