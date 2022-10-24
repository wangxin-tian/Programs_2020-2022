<%--
  Created by IntelliJ IDEA.
  User: 31065
  Date: 2021/3/30
  Time: 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>jstl的引用</title>
</head>
<body>
<c:out value="hello world"></c:out>
<c:set var="myname" value="wangxin"></c:set>
<c:set var="schoolname" value="hbxy"></c:set>

<br>
<c:if test="${myname != ''}">${myname}</c:if>
<br>
<c:if test="${schoolname == null}">${schoolname}</c:if>
</body>
</html>
