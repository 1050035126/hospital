<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>
        用户管理-添加
    </title>
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
    <form class="layui-form"
          action="AddCase.action?doctor=<%=request.getSession().getAttribute("name")%>&grade=<%=request.getSession().getAttribute("grade")%>"
          method="post">
        <div class="layui-form-item">
            <label for="L_username" class="layui-form-label">
                <span class="x-red">*</span>病人姓名
            </label>
            <div class="layui-input-inline">

                <select id="username" name="patient" class="layui-input">
                    <s:iterator id="list" value="ap">
                        <option value="${name}">${name}</option>
                    </s:iterator>
                </select>

            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_email" class="layui-form-label">
                <span class="x-red">*</span>病例内容</label>
            <div class="layui-input-inline">
                <textarea id="caseText" style="height:200px;" name="text" class="layui-input"></textarea>
            </div>
        </div>


        <div class="layui-form-item">
            <label for="L_repass" class="layui-form-label">
            </label>
            <button type="submit" class="layui-btn" lay-filter="add" lay-submit="">
                增加
            </button>
        </div>
    </form>
</div>
<script src="./js/jquery-1.8.3.min.js" charset="utf-8">
</script>
<script src="./lib/layui/layui.js" charset="utf-8">
</script>
<script src="./js/x-layui.js" charset="utf-8">
</script>

<script>
    $(document).ready(function () {
        var caseText = $("#caseText").text();

        var myDate = new Date();
        var year = myDate.getFullYear();
        var month = myDate.getMonth() + 1;
        var date = myDate.getDate();
        var h = myDate.getHours();       //获取当前小时数(0-23)
        var m = myDate.getMinutes();     //获取当前分钟数(0-59)
        var s = myDate.getSeconds();

        var now = year + "年" + month + "月" + date + "日" + " " + h + ":" + m + ":" + s;

        caseText = caseText + "\n--------------" + now + "--------------\n"
        $("#caseText").text(caseText);

    });
</script>
<script>
    layui.use(['form', 'layer'], function () {
        $ = layui.jquery;
        var form = layui.form()
            , layer = layui.layer;

        //自定义验证规则
        form.verify({
            nikename: function (value) {
                if (value.length < 5) {
                    return '昵称至少得5个字符啊';
                }
            }
            , pass: [/(.+){6,12}$/, '密码必须6到12位']
            , repass: function (value) {
                if ($('#L_pass').val() != $('#L_repass').val()) {
                    return '两次密码不一致';
                }
            }
        });

        //监听提交
        //           form.on('submit(add)', function(data){
        //            console.log(data);
        //发异步，把数据提交给php
        //            layer.alert("增加成功", {icon: 6},function () {
        // 获得frame索引
        //                var index = parent.layer.getFrameIndex(window.name);
        //关闭当前frame
        //               parent.layer.close(index);
        //           });
        //           return false;
        //         });


    });
</script>
<script>
    var _hmt = _hmt || [];
    (function () {
        var hm = document.createElement("script");
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>
</body>

</html>