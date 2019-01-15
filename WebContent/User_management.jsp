<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>
        用户管理
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
    String grade = request.getSession().getAttribute("grade").toString();
%>
<div class="x-nav">
            <span class="layui-breadcrumb">
              <a><cite>首页</cite></a>
              <a><cite>用户管理</cite></a>
            </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="UserManageAction.action" title="刷新"><i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <form class="layui-form x-center" action="UserManageAction.action" style="width:500px">
        <div class="layui-form-pane" style="margin-top: 15px;">
            <div class="layui-form-item">
                <div class="layui-input-inline" style="width:400px">
                    <input type="text" name="searchWords" value="${searchWords}" placeholder="搜索医生名称" autocomplete="off"
                           class="layui-input">
                </div>
                <div class="layui-input-inline" style="width:80px">
                    <button class="layui-btn" lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i>
                    </button>
                </div>
            </div>
        </div>
    </form>
    <xblock>
        <% if (grade.equals("1")) { %>
        <button class="layui-btn" onclick="user_management_add('添加用户','user_management_add.jsp','600','500')"><i
                class="layui-icon">&#xe608;</i>添加
        </button>
        <%} %>
        <span class="x-right" style="line-height:25px"></span></xblock>
    <table class="layui-table">
        <thead>
        <tr>
            <th>
                <input type="checkbox" name="" value="">
            </th>
            <th>
                ID
            </th>
            <th>
                用户名
            </th>
            <th>
                用户角色
            </th>
            <th>
                性别
            <th>
                年龄
            </th>
            <th>
                手机号
            </th>
            <th>
                电子邮箱
            </th>
            <%if (grade.equals("1")) { %>
            <th>
                操作
            </th>
            <%} %>
        </tr>
        </thead>
        <tbody>

        <s:iterator id="list" value="umb">

            <tr>
                <td>
                    <input type="checkbox" value="1" name="">
                </td>
                <td>
                        ${id}
                </td>
                <td><u style="cursor:pointer"
                       onclick="user_management_show('${name}','user_management_show.jsp?name=${name}&id=${id}&isDoc=${isDoc}&sex=${sex}&phone=${phone}&email=${email}&age=${age}','10001','360','400')">${name}</u>
                </td>
                <td>
                        ${isDoc}</td>
                <td>
                        ${sex}</td>
                <td>
                        ${age}
                </td>
                <td>
                        ${phone}
                </td>
                <td>
                        ${email}
                </td>
                <%if (grade.equals("1")) { %>
                <td class="td-manage">
                    <a title="编辑" href="javascript:;"
                       onclick="user_management_edit('编辑','user_management_edit.jsp?id=${id}&isDoctor=${isDoc}','4','','510')"
                       class="ml-5" style="text-decoration:none">
                        <i class="layui-icon">&#xe642;</i>
                    </a>
                    <a style="text-decoration:none"
                       onclick="user_management_password('修改密码','user_password.jsp?id=${id}&type=${isDoc}','10001','600','400')"
                       href="javascript:;" title="修改密码">
                        <i class="layui-icon">&#xe631;</i>
                    </a>
                    <a title="删除" onclick="member_del(this,'${id}','${isDoc}')"
                       style="text-decoration:none">
                        <i class="layui-icon">&#xe640;</i>
                    </a>
                </td>
                <%} %>
            </tr>
        </s:iterator>
        </tbody>
    </table>

    <div>
        <a href="UserManageAction.action?currentPage=${currentPage-1}&searchWords=${searchWords}">
            <button class="layui-btn">上一页</button>
        </a>
        <a href="UserManageAction.action?currentPage=${currentPage+1}&searchWords=${searchWords}">
            <button class="layui-btn">下一页</button>
        </a>
    </div>
</div>
<br/><br/><br/>
<script src="./lib/layui/layui.js" charset="utf-8"></script>
<script src="./js/x-layui.js" charset="utf-8"></script>
<script>
    layui.use(['laydate', 'element', 'laypage', 'layer'], function () {
        $ = layui.jquery;//jquery
        laydate = layui.laydate;//日期插件
        lement = layui.element();//面包导航
        layer = layui.layer;//弹出层

        //以上模块根据需要引入


        var start = {
            min: laydate.now()
            , max: '2099-06-16 23:59:59'
            , istoday: false
            , choose: function (datas) {
                end.min = datas; //开始日选好后，重置结束日的最小日期
                end.start = datas //将结束日的初始值设定为开始日
            }
        };

        var end = {
            min: laydate.now()
            , max: '2099-06-16 23:59:59'
            , istoday: false
            , choose: function (datas) {
                start.max = datas; //结束日选好后，重置开始日的最大日期
            }
        };

    });

    //批量删除提交
    function delAll() {
        layer.confirm('确认要删除吗？', function (index) {
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
        });
    }

    /*用户-添加*/
    function user_management_add(title, url, w, h) {
        x_admin_show(title, url, w, h);
    }

    /*用户-查看*/
    function user_management_show(title, url, id, w, h) {
        x_admin_show(title, url, w, h);
    }

    /*用户-停用*/
    function member_stop(obj, id) {
        layer.confirm('确认要停用吗？', function (index) {
            //发异步把用户状态进行更改
            $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_start(this,id)" href="javascript:;" title="启用"><i class="layui-icon">&#xe62f;</i></a>');
            $(obj).parents("tr").find(".td-status").html('<span class="layui-btn layui-btn-disabled layui-btn-mini">已停用</span>');
            $(obj).remove();
            layer.msg('已停用!', {icon: 5, time: 1000});
        });
    }

    /*用户-启用*/
    function member_start(obj, id) {
        layer.confirm('确认要启用吗？', function (index) {
            //发异步把用户状态进行更改
            $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_stop(this,id)" href="javascript:;" title="停用"><i class="layui-icon">&#xe601;</i></a>');
            $(obj).parents("tr").find(".td-status").html('<span class="layui-btn layui-btn-normal layui-btn-mini">已启用</span>');
            $(obj).remove();
            layer.msg('已启用!', {icon: 6, time: 1000});
        });
    }

    // 用户-编辑
    function user_management_edit(title, url, id, w, h) {
        x_admin_show(title, url, w, h);
    }

    /*密码-修改*/
    function user_management_password(title, url, id, w, h) {
        x_admin_show(title, url, w, h);
    }

    /*用户-删除*/
    function member_del(obj, id, type) {
        layer.confirm('确认要删除吗？', function (index) {
            //发异步删除数据
            $.post("DeleteManage.action",
                {
                    "id": id,
                    "type": type
                },
                function (data, status) {
                }
            );
            $(obj).parents("tr").remove();
            layer.msg('已删除!', {icon: 1, time: 1000});
        });
    }
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