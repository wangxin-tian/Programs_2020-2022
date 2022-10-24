<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>产品列表</title>
    <style>
        *{font-size: 10px}
    </style>
</head>
<body>
<table width="800" align="center"
       style="border: 1px solid rgba(214,214,214,1)" >
    <tr style="height: 30px">
        <td style="margin-top: 10px">
            &nbsp;&nbsp;产品列表&nbsp;&nbsp;
            <input type="button" border="0" id="btnadd" value="添加产品"
                   style="background: rgb(121,149,224); color: #ffffff; border: 0px rgb(121,149,224)"
                   onclick="add()">
        </td>
    </tr>
    <tr>
        <td>
            <table width="98%" cellpadding="10" align="center"
                   style="border-top: 1px solid rgba(214,214,214,1)"
                   cellspacing="0">
                <tr align="center" style="border-top: 1px solid rgba(214,214,214,1)">
                    <td width="5%"></td>
                    <td width="40%" align="left">产品名称</td>
                    <td width="10%">产品类型</td>
                    <td width="10%">生产厂家</td>
                    <td width="15%">是否上架销售</td>
                    <td>操作</td>
                </tr>
                <c:forEach var="product" items="${productlist}"
                           varStatus="varstatus">
                    <tr align="center">
                        <td style="border-top: 1px solid rgba(214,214,214,1)">
                            <c:out value="${varstatus.index+1}"/>
                        </td>
                        <td align="left" style="border-top: 1px solid rgba(214,214,214,1)">${product.productName}</td>
                        <td style="border-top: 1px solid rgba(214,214,214,1)">${product.productType}</td>
                        <td style="border-top: 1px solid rgba(214,214,214,1)">${product.manufacturer}</td>
                        <td style="border-top: 1px solid rgba(214,214,214,1)">
                            <c:if test="${product.canSale=='0'}">否</c:if>
                            <c:if test="${product.canSale=='1'}">是</c:if>
                        </td>
                        <td style="border-top: 1px solid rgba(214,214,214,1)">
                            <input type="button" id="btnEdit" value="修改"
                                   style="background: rgba(204,220,255,1); border: 1px solid rgb(74,128,255);
                                    color: rgba(74,128,255,1)"
                                   onclick="edit(${product.productId})">
                            <input type="button" id="btnDel" value="删除"1
                                   style="background: rgb(255,219,226); border: 1px solid rgba(255,59,144,1);
                                   color: rgba(255,59,144,1)"
                                   onclick="delet(${product.productId})">
                        </td>
                    </tr>
                </c:forEach>

            </table>
        </td>
    </tr>
</table>
<script>
    function add() {
        window.location.href = "${pageContext.request.contextPath}/toproductadd";
    }

    function edit(id) {
        window.location.href = "${pageContext.request.contextPath}/toproductedit?productId=" + id;
    }

    function delet(id) {
        if (confirm("要删除该数据吗?")) {
            window.location.href = "${pageContext.request.contextPath}/productdelete?productId=" + id;
        }

    }
</script>
</body>
</html>
