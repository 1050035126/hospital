<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
            <form class="layui-form" action="Register.action?limit=3&hdoctor=<%=request.getSession().getAttribute("username")%>"  method="post">
                <div class="layui-form-item">
                    <label for="L_email" class="layui-form-label">
                        <span class="x-red">*</span>用户名称(工号)</label>
                    <div class="layui-input-inline">
                        <input type="text"  name="id" class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">
                        <span class="x-red">*</span>必填
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_email" class="layui-form-label">
                        <span class="x-red">*</span>姓名</label>
                    <div class="layui-input-inline">
                        <input type="text"  name="name" class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">
                        <span class="x-red">*</span>必填
                    </div>
                </div>
                
                <div class="layui-form-item">
                    <label for="L_pass" class="layui-form-label">
                        <span class="x-red">*</span>密码
                    </label>
                    <div class="layui-input-inline">
                        <input type="password" id="L_pass" name="pass" required lay-verify="pass" autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">
                        6到16个字符
                    </div>
                </div>
     <!--             <div class="layui-form-item">
                    <label for="L_repass" class="layui-form-label">
                        <span class="x-red">*</span>确认密码
                    </label>
                    <div class="layui-input-inline">
                        <input type="password" id="L_repass" name="repass" required lay-verify="repass"
                        autocomplete="off" class="layui-input">
                    </div>
                </div> 
      -->
      			<div class="layui-form-item">
                    <label for="L_username" class="layui-form-label">
                        <span class="x-red">*</span>性别
                    </label>
                    <div class="layui-input-inline">
	                    <select id="username" name="subject"  class="layui-input">
	                        	<option value="外科">外科</option>
	                    </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_username" class="layui-form-label">
                        <span class="x-red">*</span>性别
                    </label>
                    <div class="layui-input-inline">
	                    <select id="username" name="sex"  class="layui-input">
	                        	<option value="男">男</option>
	                        	<option value="女">女</option>
	                    </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_username" class="layui-form-label">
                        <span class="x-red">*</span>治疗类型
                    </label>
                    <div class="layui-input-inline">
	                    <select id="username" name="cure"  class="layui-input">
	                    		<option value="1">普通治疗</option>
	                        	<option value="2">住院治疗</option>
	                        	<option value="3">手术治疗</option>
	                    </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_username" class="layui-form-label">
                        <span class="x-red">*</span>护士等级
                    </label>
                    <div class="layui-input-inline">
	                    <select id="username" name="nurse"  class="layui-input">
	                    		<option value="0">无</option>
	                        	<option value="1">一级护士</option>
	                        	<option value="2">二级护士</option>
	                        	<option value="3">三级护士</option>
	                    </select>
                    </div>
                </div>
                
                 <div class="layui-form-item">
                    <label for="L_username" class="layui-form-label">
                        <span class="x-red">*</span>年龄</label>
                    <div class="layui-input-inline">
                        <input id="username" name="age"  class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_username" class="layui-form-label">
                        <span class="x-red">*</span>手机号</label>
                    <div class="layui-input-inline">
                        <input id="username" name="phone"  class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_username" class="layui-form-label">
                        <span class="x-red">*</span>电子邮箱</label>
                    <div class="layui-input-inline">
                        <input id="username" name="email"  class="layui-input"/>
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
        <script src="./lib/layui/layui.js" charset="utf-8">
        </script>
        <script src="./js/x-layui.js" charset="utf-8">
        </script>
        <script>
            layui.use(['form','layer'], function(){
                $ = layui.jquery;
              var form = layui.form()
              ,layer = layui.layer;
            
              //自定义验证规则
              form.verify({
                nikename: function(value){
                  if(value.length < 5){
                    return '昵称至少得5个字符啊';
                  }
                }
                ,pass: [/(.+){6,12}$/, '密码必须6到12位']
                ,repass: function(value){
                    if($('#L_pass').val()!=$('#L_repass').val()){
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
        (function() {
          var hm = document.createElement("script");
          var s = document.getElementsByTagName("script")[0]; 
          s.parentNode.insertBefore(hm, s);
        })();
        </script>
    </body>

</html>