<%--
  Created by IntelliJ IDEA.
  User: 31065
  Date: 2021/4/10
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户信息修改</title>
</head>
<body>
<table border="0" width="60%"
       cellpadding="5"
       align="center">
    <tr>
        <td>
            <form name="frmUser" id="frmUser" action="" method="post">
                <table align="center" width="800" border="0">
                    <tr>
                        <td>
                            ⽤户修改
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <table border="1"
                                   width="100%"
                                   cellspacing="0"
                                   cellpadding="10">
                                <input type="hidden" name="userId" value="${user.userId}" >
                                <tr>
                                    <td align="right">&nbsp;&nbsp;&nbsp;学号:</td>
                                    <td>
                                        <input type="text" id="userNo" name="userNo" value="${user.userNo}">
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right">&nbsp;&nbsp;姓名:</td>
                                    <td>
                                        <input type="text" id="userName" name="userName" value="${user.userName}">
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right">&nbsp;&nbsp;性别:</td>
                                    <td>
                                        <input type="radio" name="sex" value="0" <c:if test="${user.sex == '0'}">checked</c:if>/>男&nbsp;
                                        <input type="radio" name="sex" value="1" <c:if test="${user.sex == '1'}">checked</c:if>/>⼥
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right">&nbsp;&nbsp;出生地:</td>
                                    <td>
                                        <input type="text" id="birthplace" name="birthplace" value="${user.birthplace}">
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right">&nbsp;&nbsp;&nbsp;班级:</td>
                                    <td>
                                        <select name="clazz">
                                            <c:forEach var="clazz" items="${clazzlist}">
                                                <option <c:if test="${clazz == user.clazz}">selected</c:if> value="${clazz}" >${clazz}</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right">&nbsp;&nbsp;地址:</td>
                                    <td>
                                        <input type="text" id="address" name="address" value="${user.address}">
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </form>
        </td>
    </tr>
    <tr>
        <td align="center">
            <button name="btnSave" onclick="userSave()">保存</button>
            <button name="btnCanel" onclick="cancel()">取消</button>
        </td>
    </tr>
</table>
<script>
    function userSave(){
        document.frmUser.action='${pageContext.request.contextPath}/useredit';
        document.frmUser.submit();
    }
    function cancel(){
        window.location.href='${pageContext.request.contextPath}/userlist';
    }
</script>
</body>
</html>