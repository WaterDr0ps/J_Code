<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>add</title>
</head>
<body>
<form action="/brand-demo/addServlet" method="post">
    <h3>添加品牌</h3><br>
    品牌名称：<input type="text" id="brandName" name="brandName"><br>
    企业名称：<input type="text" id="companyName" name="companyName"><br>
    排序：<input type="text" id="ordered" name="ordered"><br>
    描述信息：<textarea rows="5" cols="20" name="description" id="description"></textarea><br>
    状态：
    <input type="radio" name="status" value="0">禁用
    <input type="radio" name="status" value="1">启用<br>

    <input type="submit" id="submit">

</form>


</script>
</body>
</html>
