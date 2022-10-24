<%--
  Created by IntelliJ IDEA.
  User: 31065
  Date: 2021/4/1
  Time: 8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书信息</title>
</head>
<body>
<!--通过插值表达式获得转发过来的数据-->
<table width="600px"
       align="center"
       cellpadding="5"
       cellspacing="0"
       border="1">
    <tr>
        <td>图书编号：</td>
        <td>${bookId}</td>
    </tr>
    <tr>
        <td>图书名称：</td>
        <td>${bookName}</td>
    </tr>
    <tr>
        <td>图书价格：</td>
        <td>${bookPrice}</td>
    </tr>
    </tr>
</table>
</body>
</html>
