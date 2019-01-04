<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta charset="utf-8">
        <title>
            用户管理-查看
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
	   			String doctor=request.getParameter("doctor");
	   			String patient=request.getParameter("patient");
	   			String time=request.getParameter("time");
	   			String text=request.getParameter("text");
			%>
        	<div class="x-body">
			
            <blockquote class="layui-elem-quote">
                <img src="images/0.jpg" class="layui-circle" style="width:50px;float:left">
                <dl style="margin-left:80px; color:#019688">
                <dt><span >病历查看</span> <span ></span></dt>
                <dd style="margin-left:0"></dd>
              </dl>
            </blockquote>
            <div class="pd-20">
              <table  class="layui-table" lay-skin="line" id="picOutDiv">
                <tbody>
                  <tr>
                    <th  width="80">ID</th>
                    <td><%=id%></td>
                  </tr>
                  <tr>
                    <th  width="80">病人</th>
                    <td><%=patient%></td>
                  </tr>
                  <tr>
                    <th  width="80">主治医生</th>
                    <td><%=doctor%></td>
                  </tr>
                  <tr>
                    <th  width="80">时间</th>
                    <td><%=time%></td>
                  </tr>
                  <tr>
                    <th  width="80">病历</th>
                    <td><%=text%></td>
                  </tr>
                </tbody>
              </table>
            </div>
            <div class="layui-form-item">
                    <label for="L_repass" class="layui-form-label">
                    </label>
                    <button type="submit"  class="layui-btn" lay-filter="add" lay-submit="">
                        打印
                    </button>
                </div>
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

              console.log(parent);
              //监听提交
              form.on('submit(add)', function(data){
            	  var newstr = document.getElementById("picOutDiv").innerHTML;//得到需要打印的元素HTML
	          		$('body').children().hide();
	          		var imgDom = $(newstr);
	          		$('body').append(imgDom);
	          		$(".pic").offset({top:0,left:0});
	          		$(".pic").width("100%");
	          		$(".pic").height("100%");
	          		window.print();
	          		$('body').children().show();
	          		imgDom.remove();
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