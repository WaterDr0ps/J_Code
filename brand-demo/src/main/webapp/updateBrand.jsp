<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>update</title>
</head>
<body>
<form action="/brand-demo/updateServlet" method="post">
    <h3>修改品牌</h3><br>
    <input type="hidden" name="id" value="${brand.id}">
    品牌名称：<input type="text" name="brandName" value="${brand.brandName}"><br>
    企业名称：<input type="text" name="companyName" value="${brand.companyName}"><br>
    排序：<input type="text" name="ordered" value="${brand.ordered}"><br>
    描述信息：<textarea rows="5" cols="20" name="description">${brand.description}</textarea><br>
    状态：
    <c:if test="${brand.status == 0}">
        <input type="radio" name="status" value="0" checked>禁用
        <input type="radio" name="status" value="1">启用<br>
    </c:if>
    <c:if test="${brand.status == 1}">
        <input type="radio" name="status" value="0">禁用
        <input type="radio" name="status" value="1" checked>启用<br>
    </c:if>

    <input type="submit" id="submit">

</form>

<%--<script type="text/javascript">
    document.getElementById("submit").onclick=function () {
        location.href="/brand-demo/"
    }
</script>--%>

</body>
</html>
