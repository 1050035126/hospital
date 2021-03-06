<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
	    String id=request.getParameter("id");
    	String text=request.getParameter("text");
    %>
        <div class="x-body">
            <form class="layui-form" action="ChangeCM.action?type=medicine&id=<%=id%>" method="post">
                <label for="L_email" class="layui-form-label">
                        <span class="x-red">*</span>ID</label>
                    <div class="layui-input-inline">
                        <input type="text" id="L_username" disabled="" value="<%=id%>" class="layui-input">
                    </div>
                </div>                
                
                <div class="layui-form-item">
                    <label for="L_email" class="layui-form-label">
                        <span class="x-red">*</span>药品名称</label>
                    <div class="layui-input-inline">
                        <input type="text" value="<%=text%>" style="height:100px;" name="text" class="layui-input">
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
            layui.use(['form','layer'], function(){
                $ = layui.jquery;
              var form = layui.form()
              ,layer = layui.layer;
            
             
              //监听提交
              form.on('submit(save)', function(data){
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
        (function() {
          var hm = document.createElement("script");
          var s = document.getElementsByTagName("script")[0]; 
          s.parentNode.insertBefore(hm, s);
        })();
        </script>
    </body>

</html>