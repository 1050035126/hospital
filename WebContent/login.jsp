<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

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
        <form action="Login.action" class="layui-form" method="post"><input
                name="__RequestVerificationToken"
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
                    <option value="4">管理员</option>
                </select>
            </div>
            <!---->

            <div class="layui-form-item">
                <label class="beg-login-icon">
                    <i class="layui-icon">&#xe612;</i>
                </label>
                <input id="name" type="text" name="name" lay-verify="userName" autocomplete="off"
                       placeholder="请输入登录名"
                       class="layui-input">
            </div>
            <div class="layui-form-item">
                <label class="beg-login-icon">
                    <i class="layui-icon">&#xe642;</i>
                </label>
                <input id="password" type="password" name="pass" lay-verify="password"
                       autocomplete="off"
                       placeholder="请输入密码" class="layui-input">
            </div>
            <div class="layui-form-item">
                <div class="beg-pull-left beg-login-remember">
                    <label>记住帐号？</label>
                    <input id="rememberMe" type="checkbox" name="rememberMe" value="true"
                           lay-skin="switch" checked
                           title="记住帐号">
                </div>
                <div class="beg-pull-right">
                    <button id="loginButton" type="button" class="layui-btn layui-btn-primary">
                        <i class="layui-icon">&#xe650;</i> 登录
                    </button>
                </div>

            </div>
        </form>
        <div class="beg-clear" style="float: right"><a onclick="showRegisterFrame()">点击注册</a></div>
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

    showRegisterFrame = function () {
        var layerObject = layer.open({
            title: "用户注册",
            type: 2,
            area: ['500px', '500px'],
            fix: false, //不固定
            maxmin: true,
            shadeClose: true,
            shade: 0.4,
            content: "user_register.jsp"
            , btn: ['确定', '取消'] //只是为了演示
            , yes: function (index, layero) {
                var body = layer.getChildFrame('body', index);
                var iframeWin = window[layero.find('iframe')[0]['name']];//得到iframe页的窗口对象，执行iframe页的方法：

                var name = iframeWin.document.getElementById("name").value;
                var pass = iframeWin.document.getElementById("pass").value;
                var age = iframeWin.document.getElementById("age").value;
                var phone = iframeWin.document.getElementById("phone").value;
                var email = iframeWin.document.getElementById("email").value;
                var sex = iframeWin.document.getElementById("sex").value;

                //TODO:ajax 注册用户信息
                $.post("UserRegisterAction.action",{
                    "name":name,
                    "pass":pass,
                    "age":age,
                    "phone":phone,
                    "email":email,
                    "sex":sex
                },function (result) {
                    layer.closeAll();
                    layer.msg('注册成功，请登录！');
                })
            }
            , btn2: function () {
                layer.closeAll();
            }, success: function (layero) {

            }
        });
    }


</script>
</body>

</html>