<%--
  Created by IntelliJ IDEA.
  User: 31065
  Date: 2021/6/11
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加产品信息</title>
    <style>
        *{font-size: 10px}
    </style>
</head>
<body>
<form id="frmProduct" name="frmProduct" method="post">
    <table width="800" align="center"
           style="border: 1px solid rgba(214,214,214,1)">
        <tr style="height: 30px">
            <td style="margin-top: 10px">
                &nbsp;&nbsp;添加产品
                <input type="button" border="0" width="15"
                       style="float: right; height: 20px; border: 0px; background: white"
                       value="X"
                       onclick="cancel()"></input>
            </td>
        </tr>
        <tr>
            <td>
                <table width="100%"
                       border="0" style="border-top: 1px solid rgba(214,214,214,1)"
                       cellspacing="0"
                       cellpadding="10">
                    <tr>
                        <td width="25%">产品名称:</td>
                        <td>
                            <input type="text" name="productName">
                        </td>
                    </tr>
                    <tr>
                        <td>产品类型:</td>
                        <td>
                            <select name="productType">
                                <option selected hidden disabled value="">
                                    请选择产品类型
                                </option>
                                <option value="手机">
                                    手机
                                </option>
                                <option value="食品">
                                    食品
                                </option>
                                <option value="家电">
                                    家电
                                </option>
                                <option value="图书">
                                    图书
                                </option>

                            </select>

                        </td>
                    </tr>
                    <tr>
                        <td>是否上架:</td>
                        <td>
                            <input type="radio" name="canSale" value="0" checked/>否
                            <input type="radio" name="canSale" value="1"/>是
                        </td>

                    </tr>

                    <tr>
                        <td>生产厂家:</td>
                        <td>
                            <input type="text" name="manufacturer" size="50">
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td align="center">
                <div align="center">
                    <input type="button" id="btnAdd"
                           style="background: rgba(204,220,255,1); border: 1px solid rgba(74,128,255,1);
                                    color: rgba(74,128,255,1)"
                           value="保存" onclick="add()">
                    <input type="button" id="btnCancel"
                           style="background: rgb(255,219,226); border: 1px solid rgba(255,59,144,1);
                                   color: rgba(255,59,144,1)"
                           value="取消" onclick="cancel()">
                </div>
            </td>
        </tr>
    </table>
</form>
<script>
    function add() {
        document.frmProduct.action
            = "${pageContext.request.contextPath}/productadd";
        document.frmProduct.submit();
    }
    function cancel() {
        window.location.href
            ="${pageContext.request.contextPath}/productlist";
    }
</script>
</body>
</html>
