<%--
  Created by IntelliJ IDEA.
  User: 31065
  Date: 2021/6/11
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改产品信息</title>
    <style>
        *{font-size: 10px}
    </style>
</head>
<body>
<form id="frmProduct" name="frmProduct"
      method="post">
    <input type="hidden" name="productId" value="${product.productId}">
    <table width="800" align="center"
           style="border: 1px solid rgba(214,214,214,1)">
        <tr style="height: 30px">
            <td style="margin-top: 10px">
                &nbsp;&nbsp;修改产品信息
                <input type="button" border="0" width="15"
                       style="float: right; height: 20px; border: 0px; background: white"
                       value="X"
                       onclick="cancel()"></input>
            </td>
        </tr>
        <tr>
            <td>
                <table border="0" style="border-top: 1px solid rgba(214,214,214,1)"
                       width="100%"
                       cellspacing="0"
                       cellpadding="10">
                    <tr>
                        <td width="25%">产品名称:</td>
                        <td>
                            <input type="text" name="productName"
                                   value="${product.productName}">
                        </td>
                    </tr>
                    <tr>
                        <td>产品类型:</td>
                        <td>
                            <select name="productType">
                                <option value="手机"
                                        <c:if test="${product.productType=='手机'}">
                                            selected</c:if>>
                                    手机
                                </option>
                                <option value="食品"
                                        <c:if test="${product.productType=='食品'}">
                                            selected</c:if>>
                                    食品
                                </option>
                                <option value="家电"
                                        <c:if test="${product.productType=='家电'}">
                                            selected</c:if>>
                                    家电
                                </option>
                                <option value="图书"
                                        <c:if test="${product.productType=='图书'}">
                                            selected</c:if>>
                                    图书
                                </option>

                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>是否上架:</td>
                        <td>
                            <input type="radio" name="canSale" value="0"
                                    <c:if test="${product.canSale=='0'}">
                                        checked</c:if> />否
                            <input type="radio" name="canSale" value="1"
                                   <c:if test="${product.canSale=='1'}">
                                        checked</c:if> />是
                        </td>

                    </tr>
                    <tr>
                        <td>生产厂家:</td>
                        <td>
                            <input type="text" name="manufacturer" size="50"
                                   value="${product.manufacturer}">
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td align="center">
                <div align="center">
                    <input type="button" id="btnSave"
                           style="background: rgba(204,220,255,1); border: 1px solid rgba(74,128,255,1);
                                    color: rgba(74,128,255,1)"
                           value="保存" onclick="save()">
                    <input type="button" id="btnCancel"
                           style="background: rgb(255,255,255); border: 1px solid rgb(217,217,217);
                                   color: rgba(255,59,144,1)"
                           value="取消" onclick="cancel()">
                </div>
            </td>
        </tr>
    </table>
</form>
<script>
    function save() {
        document.frmProduct.action
            = "${pageContext.request.contextPath}/productedit";
        document.frmProduct.submit();
    }

    function cancel() {
        window.location.href
            = "${pageContext.request.contextPath}/productlist";
    }
</script>
</body>
</html>
