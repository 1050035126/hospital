<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <title>登录</title>
    <link rel="stylesheet" href="lib/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="css/login.css"/>

    <script src="js/jquery-1.8.3.min.js" type="text/javascript"></script>
    <script src="js/jquery.cookie.js" type="text/javascript"></script>
</head>
<script type="text/javascript">
    $(function () {
        var name = $.cookie('name');
        var password = $.cookie('password')
        var selectGrade = $.cookie('selectGrade')

        if (name != "" && name != undefined) {
            $("#name").val(name)
            $("#password").val(password)
            $("#selectGrade").val(selectGrade)
        }

        $("#loginButton").click(function () {
            if ($("#rememberMe").get(0).checked) {
                //创建cookie
                $.cookie('name', $("#name").val(), {expires: 7});
                $.cookie('password', $("#password").val(), {expires: 7});
                $.cookie('selectGrade', $("#selectGrade").val(), {expires: 7});
            } else {
                $.cookie('name', "", {expires: 7});
                $.cookie('password', "", {expires: 7});
                $.cookie('selectGrade', "1", {expires: 7});
            }
            $("form").submit()
        });


    })


</script>


<body class="beg-login-bg" style="background:url(./images/bg.jpg) no-repeat;background-size:cover">
<div class="beg-login-box">
    <header>
        <h1>欢迎登录</h1>
    </header>
    <div class="beg-login-main">
        <form action="Login.action" class="layui-form" method="post"><input name="__RequestVerificationToken"
                                                                            type="hidden"
                                                                            value="fkfh8D89BFqTdrE2iiSdG_L781RSRtdWOH411poVUWhxzA5MzI8es07g6KPYQh9Log-xf84pIR2RIAEkOokZL3Ee3UKmX0Jc8bW8jOdhqo81"/>

            <!---->
            <div class="layui-form-item">
                <label class="beg-login-icon">
                    <i class="layui-icon">&#xe612;</i>
                </label>
                <select id="selectGrade" name="grade">
                    <option value="1">医生</option>
                    <option value="2">实习医生</option>
                    <option value="3">病人</option>
                </select>
            </div>
            <!---->

            <div class="layui-form-item">
                <label class="beg-login-icon">
                    <i class="layui-icon">&#xe612;</i>
                </label>
                <input id="name" type="text" name="name" lay-verify="userName" autocomplete="off" placeholder="请输入登录名"
                       class="layui-input">
            </div>
            <div class="layui-form-item">
                <label class="beg-login-icon">
                    <i class="layui-icon">&#xe642;</i>
                </label>
                <input id="password" type="password" name="pass" lay-verify="password" autocomplete="off"
                       placeholder="请输入密码" class="layui-input">
            </div>
            <div class="layui-form-item">
                <div class="beg-pull-left beg-login-remember">
                    <label>记住帐号？</label>
                    <input id="rememberMe" type="checkbox" name="rememberMe" value="true" lay-skin="switch" checked
                           title="记住帐号">
                </div>
                <div class="beg-pull-right">
                    <button id="loginButton" type="button" class="layui-btn layui-btn-primary">
                        <i class="layui-icon">&#xe650;</i> 登录
                    </button>
                </div>
                <div class="beg-clear"></div>
            </div>
        </form>
    </div>

</div>
<script type="text/javascript" src="lib/layui/layui.js"></script>
<!-- 此处可以去掉基础密码那一块儿 -->
<script>
    layui.use(['layer', 'form'], function () {
        var layer = layui.layer,
            $ = layui.jquery,
            form = layui.form();

    });
</script>
</body>

</html>