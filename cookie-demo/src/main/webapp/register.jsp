<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>register</title>

    <style>
        * {
            margin: 0;
            padding: 0;
        }

        html {
            height: 100%;
        }

        body {
            height: 100%;
        }

        .container {
            height: 100%;
            background-image: linear-gradient(to right, #999999, #330867);
        }

        .login-wrapper {
            background-color: bisque;
            width: 358px;
            height: 588px;
            border-radius: 15px;
            padding: 0 50px;
            position: relative;
            left: 50%;
            top: 50%;
            transform: translate(-50%, -50%);
        }

        .header {
            font-size: 38px;
            font-weight: bold;
            text-align: center;
            line-height: 200px;
        }

        .input-item {
            display: inline-block;
            width: 100%;
            margin-bottom: 25px;
            border: 0;
            padding: 10px;
            border-bottom: 1px solid rgb(128, 125, 125);
            font-size: 15px;
            outline: none;
        }

        .input-item::placeholder {
            text-transform: uppercase;
        }

        #checkCode{
            width: 30%;
        }

        .btn {
            border: 0;
            padding: 10px;
            width: 105%;
            margin-top: 40px;
            background-image: linear-gradient(to right, #a6c1ee, #fbc2eb);
            color: #fff;
        }

        .msg {
            text-align: center;
            line-height: 88px;
        }

        a {
            text-decoration-line: none;
            color: #abc1ee;
        }
        p{
            position: relative;
            top: -12px;
        }
        img{
            position: absolute;
            margin-top: -5px;
            margin-left: 5px;
        }
        #changeImg{
            position: relative;
            left: 155px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="login-wrapper">
        <div class="header">注册</div>
        <div class="form-wrapper">
            <form action="/cookie-demo/registerServlet" method="post" id="form">
                <input type="text" name="username" placeholder="username" class="input-item">
                <p style="color: red">${msg_err_user}</p>
                <input type="password" name="password" placeholder="password" class="input-item">
                <input type="text" name="checkCode" placeholder="checkCode" class="input-item" id="checkCode">
                <img src="/cookie-demo/checkCodeServlet" id="checkCodeImg">
                <a href="#" id="changeImg"> 看不清?</a>
                <p style="color: red">${msg_err_verify}</p>
                <input type="submit" class="btn" value="注册">
            </form>
        </div>
        <div class="msg">
            已有账户?
            <a href="/cookie-demo/index.jsp">登陆</a>
        </div>
    </div>
</div>

<script type="text/javascript">
    document.getElementById("changeImg").onclick=function () {
        document.getElementById("checkCodeImg").src="/cookie-demo/checkCodeServlet?"+new Date().getMilliseconds();
    }
</script>

</body>
</html>



