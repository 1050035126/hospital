<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="./css/x-admin.css" media="all">
</head>
<body>
<div class="x-body">
    <form class="layui-form" action="Register.action?limit=3&hdoctor=<%=request.getSession().getAttribute("username")%>"  method="post">
        <div class="layui-form-item">
            <label for="L_email" class="layui-form-label">
                <span class="x-red">*</span>姓名</label>
            <div class="layui-input-inline">
                <input id="name" type="text"  name="name" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="L_pass" class="layui-form-label">
                <span class="x-red">*</span>密码
            </label>
            <div class="layui-input-inline">
                <input type="password" id="pass" name="pass" required lay-verify="pass" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="" class="layui-form-label">
                <span class="x-red">*</span>性别
            </label>
            <div class="layui-input-inline">
                <select id="sex" name="sex"  class="layui-input" style="display: block">
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_username" class="layui-form-label">
                <span class="x-red">*</span>年龄</label>
            <div class="layui-input-inline">
                <input id="age" name="age"  class="layui-input"/>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_username" class="layui-form-label">
                <span class="x-red">*</span>手机号</label>
            <div class="layui-input-inline">
                <input id="phone" name="phone"  class="layui-input"/>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_username" class="layui-form-label">
                <span class="x-red">*</span>电子邮箱</label>
            <div class="layui-input-inline">
                <input id="email" name="email"  class="layui-input"/>
            </div>
        </div>
    </form>
</div>
<script src="./lib/layui/layui.js" charset="utf-8">
</script>
<script src="./js/x-layui.js" charset="utf-8"></script>
</body>
</html>