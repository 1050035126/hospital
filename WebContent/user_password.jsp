<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta charset="utf-8">
        <title>
            用户管理-修改密码
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
		String type=request.getParameter("type");
		String id=request.getParameter("id");
		String grade="0";
		if(type.equals("在职医生")){
			grade="1";
		}else if(type.equals("实习医生")){
			grade="2";
		}else{
			grade="3";
		}
	%>
        <div class="x-body">
            <form class="layui-form" action="Uppass.action?id=<%=id%>&grade=<%=grade%>" method="post">
                <div class="layui-form-item">
                    <label for="L_username" class="layui-form-label">
                        id
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="L_username" disabled="" value="<%=id%>" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_repass" class="layui-form-label">
                        <span class="x-red">*</span>旧密码
                    </label>
                    <div class="layui-input-inline">
                        <input type="password" id="L_repass" name="pass" required lay-verify="required"
                        autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_pass" class="layui-form-label">
                        <span class="x-red">*</span>新密码
                    </label>
                    <div class="layui-input-inline">
                        <input type="password" id="L_pass" name="newPass" required lay-verify="required"
                        autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">
                        6到16个字符
                    </div>
                </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_repass" class="layui-form-label">
                    </label>
                    <button  class="layui-btn" lay-filter="save" lay-submit="">
                        确定修改
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
            
              //监听提交
              form.on('submit(save)', function(data){
        //        console.log(data);
                //发异步，把数据提交给php
       //         layer.alert("修改成功", {icon: 6},function () {
                    // 获得frame索引
        //            var index = parent.layer.getFrameIndex(window.name);
                    //关闭当前frame
       //             parent.layer.close(index);
        //        });
       //         return false;
              });
              
              
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