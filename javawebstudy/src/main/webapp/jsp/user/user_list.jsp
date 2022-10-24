<%--
  Created by IntelliJ IDEA.
  User: 31065
  Date: 2021/4/8
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
<table width="80%" border="1"
       cellspacing="0"
       cellpadding="5"
       align="center">
    <tr>
        <td>
            用户列表
            <button name="btnAdd"
                    onclick="useradd()">注册</button>
        </td>
    </tr>
    <tr>
        <td>
            <table width="100%" border="1"
            cellspacing="0">
                <tr>
                    <td>序号</td>
                    <td>姓名</td>
                    <td>性别</td>
                    <td>出生地</td>
                    <td>班级</td>
                    <td>学号</td>
                    <td>地址</td>
                    <td>操作</td>
                </tr>
                <c:forEach var="user" items="${userlist}" varStatus="varStatus">
                    <tr>
                        <td>${varStatus.index +1}</td>
                        <td>${user.userName}</td>
                        <td>
                            <c:if test="${user.sex == '0'}">男</c:if>
                            <c:if test="${user.sex == '1'}">女</c:if>
                        </td>
                        <td>${user.birthplace}</td>
                        <td>${user.clazz}</td>
                        <td>${user.userNo}</td>
                        <td>${user.address}</td>
                        <td>
                            <button name="btnEdit" onclick="useredit(${user.userId})">修改</button>
                            <button name="btnSC" onclick="userdel(${user.userId})">删除</button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </td>
    </tr>
</table>
<script>
    function useradd(){
        //alert("你好");
        window.location.href='${pageContext.request.contextPath}/usertoadd';
    }
    function useredit(userId){
        window.location.href='${pageContext.request.contextPath}/usertoedit?userId='+userId;
    }
    function userdel(userId){
        if(confirm("啊这，你确定要删除吗？")){
            window.location.href='${pageContext.request.contextPath}/userdel?userId='+userId;
        }
    }
</script>
</body>
</html>
