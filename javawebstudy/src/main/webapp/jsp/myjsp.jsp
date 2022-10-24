<%--
  Created by IntelliJ IDEA.
  User: 31065
  Date: 2021/3/30
  Time: 8:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的jsp</title>
</head>
<body>

<!--1 传统的jsp写法-->
<%
    out.print(request.getAttribute("username"));
    out.print(request.getAttribute("pwd"));
%>

<!--2 EL表达式写法-->
${username}
${pwd}

</body>
</html>
