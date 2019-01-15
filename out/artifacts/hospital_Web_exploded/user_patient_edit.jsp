<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>
        用户管理-编辑
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
<%
    String id = request.getParameter("id");
    String grade = request.getParameter("grade");
%>
<div class="x-body">
    <form class="layui-form" action="ChangeMass.action?id=<%=id%>&grade=<%=grade%>" method="post">
        <label for="L_email" class="layui-form-label">
            <div class="layui-input-inline">
                <input style="display: none" type="text" id="L_username" disabled="" value="<%=id%>"
                       class="layui-input">
            </div>
</div>

<div class="layui-form-item">
    <label for="L_email" class="layui-form-label">
        <span class="x-red">*</span>姓名</label>
    <div class="layui-input-inline">
        <input value="${patient.name}" type="text" name="name" class="layui-input">
    </div>
    <div class="layui-form-mid layui-word-aux">
        <span class="x-red">*</span>必填
    </div>
</div>
<div class="layui-form-item">
    <label for="L_username" class="layui-form-label">
        <span class="x-red">*</span>主治医生
    </label>
    <div class="layui-input-inline">
        <select name="doctor" class="layui-input">
            <s:iterator id="list" value="adi">
                <option ${name eq patient.doctor?"selected":""} value="${name}">${id}&nbsp;&nbsp;${name}</option>
            </s:iterator>
        </select>
    </div>
</div>
<div class="layui-form-item">
    <label for="L_username" class="layui-form-label">
        <span class="x-red">*</span>性别
    </label>
    <div class="layui-input-inline">
        <select  name="sex" class="layui-input">
            <option ${patient.sex eq "男"?"selected":""} value="男">男</option>
            <option ${patient.sex eq "女"?"selected":""} value="女">女</option>
        </select>
    </div>
</div>
<div class="layui-form-item">
    <label for="L_username" class="layui-form-label">
        <span class="x-red">*</span>治疗类型
    </label>
    <div class="layui-input-inline">
        <select  name="cure" class="layui-input">
            <option ${patient.cure eq "普通治疗"?"selected":""} value="普通治疗">普通治疗</option>
            <option ${patient.cure eq "住院治疗"?"selected":""} value="住院治疗">住院治疗</option>
            <option ${patient.cure eq "手术治疗"?"selected":""} value="手术治疗">手术治疗</option>
        </select>
    </div>
</div>
<div class="layui-form-item">
    <label for="L_username" class="layui-form-label">
        <span class="x-red">*</span>护士类型
    </label>
    <div class="layui-input-inline">
        <select  name="nurse" class="layui-input">
            <option ${patient.nurse eq "0"?"selected":""} value="0">无</option>
            <option ${patient.nurse eq "一级护士"?"selected":""} value="一级护士">一级护士</option>
            <option ${patient.nurse eq "二级护士"?"selected":""} value="二级护士">二级护士</option>
            <option ${patient.nurse eq "三级护士"?"selected":""} value="三级护士">三级护士</option>
        </select>
    </div>
</div>
<div class="layui-form-item">
    <label for="L_username" class="layui-form-label">
        <span class="x-red">*</span>年龄</label>
    <div class="layui-input-inline">
        <input value="${patient.age}" name="age" class="layui-input"/>
    </div>
</div>
<div class="layui-form-item">
    <label for="L_username" class="layui-form-label">
        <span class="x-red">*</span>手机号</label>
    <div class="layui-input-inline">
        <input value="${patient.phone}" name="phone" class="layui-input"/>
    </div>
</div>
<div class="layui-form-item">
    <label for="L_username" class="layui-form-label">
        <span class="x-red">*</span>电子邮箱</label>
    <div class="layui-input-inline">
        <input  value="${patient.mail}" name="email" class="layui-input"/>
    </div>
</div>
<div class="layui-form-item">
    <label for="L_sign" class="layui-form-label">
    </label>
    <button class="layui-btn" key="set-mine" lay-filter="save" lay-submit>
        提交
    </button>
</div>
</form>
</div>
<script src="./lib/layui/layui.js" charset="utf-8">
</script>
<script src="./js/x-layui.js" charset="utf-8">
</script>
<script>
    layui.use(['form', 'layer'], function () {
        $ = layui.jquery;
        var form = layui.form()
            , layer = layui.layer;


        //监听提交
        form.on('submit(save)', function (data) {
            //   console.log(data);
            //   layer.alert("提交成功", {icon: 6},function () {
            // 获得frame索引
            //       var index = parent.layer.getFrameIndex(window.name);
            //关闭当前frame
            //       parent.layer.close(index);
            //  });
            //    return false;
        });


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