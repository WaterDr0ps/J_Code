<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>login</title>

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
            display: block;
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
    </style>
</head>
<body>
<div class="container">
    <div class="login-wrapper">
        <div class="header">欢迎登陆</div>
        <p style="color: red">${msg_err_filter}</p>
        <div class="form-wrapper">
            <form action="/cookie-demo/loginServlet" method="post" id="form">
                <input type="text" name="username" placeholder="username" class="input-item" value="${cookie.username.value}">
                <p style="color: red">${msg_err_user}</p>
                <input type="password" name="password" placeholder="password" class="input-item" value="${cookie.password.value}">
                <p>记住我 <input type="checkbox" name="remember" id="remember" value="1"></p>
                <input type="submit" class="btn" value="登陆">
            </form>
        </div>
        <div class="msg">
            没有账户?
            <a href="/cookie-demo/register.jsp">注册</a>
        </div>
    </div>
</div>

</body>
</html>


