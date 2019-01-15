<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
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
    String name = request.getSession().getAttribute("username").toString();
%>
<div class="x-nav">
            <span class="layui-breadcrumb">
              <a><cite>首页</cite></a>
              <a><cite>药品管理</cite></a>
            </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="Case.action?grade=<%=grade%>&name=<%=name%>" title="刷新"><i class="layui-icon"
                                                                        style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <form class="layui-form x-center" action="Case.action" style="width:500px">
        <input type="hidden" name="grade" value="<%=grade%>"/>
        <input type="hidden" name="name" value="<%=name%>"/>

        <div class="layui-form-pane" style="margin-top: 15px;">
            <div class="layui-form-item">
                <div class="layui-input-inline" style="width:400px">
                    <input type="text" name="searchWords" value="${searchWords}"
                           placeholder="搜索病人名称" autocomplete="off"
                           class="layui-input">
                </div>
                <div class="layui-input-inline" style="width:80px">
                    <button class="layui-btn" lay-submit="" lay-filter="sreach"><i
                            class="layui-icon">&#xe615;</i>
                    </button>
                </div>
            </div>
        </div>
    </form>
    <xblock>
        <% if (!grade.equals("3")) { %>
        <button class="layui-btn"
                onclick="user_management_add('添加病例','PatientId.action?type=case','600','500')"><i
                class="layui-icon">&#xe608;</i>添加
        </button>

        <button id="toChangeCaseListButton" onclick="toChangeCaseList()" class="layui-btn">
            查看待更新病历
        </button>
        <%} %>
        <span class="x-right" style="line-height:25px">共有数据：${count}条</span></xblock>
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
                病人
            </th>
            <th>
                主治医生
            </th>
            <th>
                时间
            </th>
            <th>
                病历
            </th>
            <th>
                审核状态
            </th>
            <% if (grade.equals("1")) { %>
            <th>
                操作
            </th>
            <%} %>
        </tr>
        </thead>
        <tbody>
        <s:iterator id="list" value="acb">

            <tr>
                <td>
                    <input type="checkbox" value="1p" name="">
                </td>
                <td>
                        ${id}
                </td>
                <td>${patient}</td>
                <td>
                        ${doctor}</td>
                <td>
                        ${time}</td>
                <td>
                    <u style="cursor:pointer"
                       onclick="user_management_show('${patient}','GetCase.action?id=${id}&returnTo=show','4','900','500')">点击此处查看病历</u>
                </td>

                <td>
                    <c:choose>
                        <c:when test="${audit=='1'}">
                            审核通过
                        </c:when>
                        <c:when test="${audit=='0'}">
                            待审核
                        </c:when>
                        <c:otherwise>
                            审核未通过
                        </c:otherwise>
                    </c:choose>
                </td>

                <% if (grade.equals("1")) { %>
                <td class="td-manage">
                    <a title="编辑" href="javascript:;"
                       onclick="user_management_edit('编辑','GetCase.action?id=${id}&returnTo=edit','4','900','500')"
                       class="ml-5" style="text-decoration:none">
                        <i class="layui-icon">&#xe642;</i>
                    </a>
                    <a title="删除" onclick="return member_del(this,'${id}')"
                       style="text-decoration:none">
                        <i class="layui-icon">&#xe640;</i>
                    </a>
                </td>
                <%} %>
            </tr>
        </s:iterator>
        </tbody>
    </table>

    <div
            <s:if test="#request.lastPage==1">style="display: none" </s:if>     >
        <a href="Case.action?currentPage=${currentPage-1}&searchWords=${searchWords}&grade=<%=grade%>&name=<%=name%>&waitToUpdate=${waitToUpdate}">
            <button class="layui-btn">上一页</button>
        </a>
        <a href="Case.action?currentPage=${currentPage+1}&searchWords=${searchWords}&grade=<%=grade%>&name=<%=name%>&waitToUpdate=${waitToUpdate}">
            <button class="layui-btn">下一页</button>
        </a>

    </div>
</div>
<br/><br/><br/>
<script src="./js/jquery-1.8.3.min.js" charset="utf-8">
</script>
<script src="./lib/layui/layui.js" charset="utf-8"></script>
<script src="./js/x-layui.js" charset="utf-8"></script>

<script>
    $(document).ready(function () {

        var waitToUpdate = ${waitToUpdate};
        var url = '';
        if (waitToUpdate == 0) {
            $("#toChangeCaseListButton").text("查看待更新病历");
            url="Case.action?waitToUpdate=1"
        } else {
            $("#toChangeCaseListButton").text("查看所有病历");
            url="Case.action?waitToUpdate=0"
        }


        toChangeCaseList = function () {
            window.location.href = url;
        }


    });
</script>
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
    function member_del(obj, id) {
        layer.confirm('确认要删除吗？', function () {
            //发异步删除数据
            $.post("DeleteCase.action",
                {
                    "id": id,
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