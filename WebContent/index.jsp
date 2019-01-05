<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>
           	欢迎登陆
        </title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="format-detection" content="telephone=no">
        <link rel="stylesheet" href="./css/x-admin.css" media="all">
    </head>
    <body>
    <%
    	if(request.getSession().getAttribute("username")==null){
    		response.sendRedirect("login.jsp");
    	}
    	String grade=request.getSession().getAttribute("grade").toString();
    %>
        <div class="layui-layout layui-layout-admin">
            <div class="layui-header header header-demo">
                <div class="layui-main">
                    <a class="logo" href="#">
                   <img src="images/logo.png"></img>
                    </a>
                    <ul class="layui-nav" lay-filter="">
                      <li class="layui-nav-item"><img src="images/0.jpg" class="layui-circle" style="border: 2px solid #A9B7B7;" width="35px" alt=""></li>
                      <li class="layui-nav-item">
                        <a href="javascript:;"><%=request.getSession().getAttribute("username") %></a>
                        <dl class="layui-nav-child"> <!-- 二级菜单 -->
                          <dd><a href="#">权限 <%=grade%></a></dd>
                          <dd><a href="#">个人信息</a></dd>
                          <dd><a href="Quit.action">切换帐号</a></dd>
                          <dd><a href="Quit.action">退出</a></dd>
                        </dl>
                      </li>
                      <!-- <li class="layui-nav-item">
                        <a href="" title="消息">
                            <i class="layui-icon" style="top: 1px;">&#xe63a;</i>
                        </a>
                        </li> -->
                      <li class="layui-nav-item x-index"><a href="#">前台首页</a></li>
                    </ul>
                </div>
            </div>
            <div class="layui-side layui-bg-black x-side">
                <div class="layui-side-scroll">
                    <ul class="layui-nav layui-nav-tree site-demo-nav" lay-filter="side">
                    <!--管理员审核-->
                    	<%if(grade.equals("1")){ %>
                        <li class="layui-nav-item">
                            <a class="javascript:;" href="javascript:;" _href="main.jsp">
                               <i class="layui-icon" style="top: 3px;">&#xe62d;</i><cite>管理员审核</cite>
                            </a>
                      <dl class="layui-nav-child">
                                <dd class="">
                                    <dd class="">
                                        <a href="javascript:;" _href="MedicineCheck.action">
                                            <cite>药品审核</cite>
                                        </a>
                                    </dd>
                                </dd>
                                <dd class="">
                                    <dd class="">
                                        <a href="javascript:;" _href="CaseCheck.action">
                                            <cite>病历审核</cite>
                                        </a>
                                    </dd>
                                </dd>
                            </dl>
                        </li>
                       <%}%>
                       <%if(!grade.equals("3")){ %>
                        <!--用户管理-->
                        <li class="layui-nav-item">
                            <a class="javascript:;" href="javascript:;" _href="UserManageAction.action">
                                <i class="layui-icon" style="top: 3px;">&#xe613;</i><cite>医生管理</cite>
                            </a>
                        </li>
                        <!--角色管理-->
                        <li class="layui-nav-item">
                            <a class="javascript:;" href="javascript:;" _href="UserPatient.action?">
                                <i class="layui-icon" style="top: 3px;">&#xe612;</i><cite>病人管理</cite>
                            </a>
                        </li>
                         <%}%>
                         <!--病例管理-->
                        <li class="layui-nav-item">
                            <a class="javascript:;" href="javascript:;" _href="Case.action?grade=<%=grade%>&name=<%=request.getSession().getAttribute("username") %>">
                                <i class="layui-icon" style="top: 3px;">&#xe612;</i><cite><%if(!grade.equals("3")){out.print("病历管理");}else{out.print("查看病历");} %></cite>
                            </a>
                        </li>
                        <!--病例管理-->
                        <li class="layui-nav-item">
                            <a class="javascript:;" href="javascript:;" _href="Medicine.action?grade=<%=grade%>&name=<%=request.getSession().getAttribute("username") %>">
                                <i class="layui-icon" style="top: 3px;">&#xe612;</i><cite><%if(!grade.equals("3")){out.print("药品管理");}else{out.print("查看药品");} %></cite>
                            </a>
                        </li>
                       
                        <!--友情链接-->
                        <li class="layui-nav-item">
                            <a class="javascript:;" href="javascript:;">
                                <i class="layui-icon" style="top: 3px;">&#xe629;</i><cite>友情链接</cite>
                            </a>
                            <dl class="layui-nav-child">
                                <dd class="">
                                    <dd class="">
                                        <a href="javascript:;" _href="http://www.gsyy.cn/">
                                            <i class="layui-icon"></i><cite>甘肃省人民医院</cite>
                                        </a>
                                    </dd>
                                </dd>
                                <dd class="">
                                    <dd class="">
                                        <a href="javascript:;" _href="http://www.ljgxb.com/index.html">
                                            <i class="layui-icon"></i><cite>兰州军区总医院</cite>
                                        </a>
                                    </dd>
                                </dd>
                                <dd class="">
                                    <dd class="">
                                        <a href="javascript:;" _href="http://www.zyxyfy.com/">
                                            <i class="layui-icon"></i><cite>甘肃中医学院附属医院</cite>
                                        </a>
                                    </dd>
                                </dd>
                                <dd class="">
                                    <dd class="">
                                        <a href="javascript:;" _href="http://www.lzdyyy.com/">
                                            <i class="layui-icon"></i><cite>兰州市第一人民医院</cite>
                                        </a>
                                    </dd>
                                </dd>
                            </dl>
                        </li>
                    </ul>
                </div>

            </div>
            <div class="layui-tab layui-tab-card site-demo-title x-main" lay-filter="x-tab" lay-allowclose="true">
                <div class="x-slide_left"></div>
                <ul class="layui-tab-title">
                    <li class="layui-this">
                        专科医院电子病历管理系统欢迎你的到来
                        <i class="layui-icon layui-unselect layui-tab-close">ဆ</i>
                    </li>
                </ul>
                <div class="layui-tab-content site-demo site-demo-body">
                    <div class="layui-tab-item layui-show">
                        <iframe frameborder="0" src="main.jsp" class="x-iframe"></iframe>
                    </div>
                </div>
            </div>
            <div class="site-mobile-shade">
            </div>
        </div>
        <script src="./lib/layui/layui.js" charset="utf-8"></script>
        <script src="./js/x-admin.js"></script>
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