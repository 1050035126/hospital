<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
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

<div class="x-body">
    <form class="layui-form" action="ChangeCM.action?type=case&id=${caseBean.id}&doctor=${caseBean.doctor}"
          method="post">
        <label for="L_email" class="layui-form-label">
            <span class="x-red">*</span>ID</label>
        <div class="layui-input-inline">
            <input type="text" id="L_username" disabled="" value="${caseBean.patient}" class="layui-input">
        </div>

        <div class="layui-form-item">
            <label for="L_email" class="layui-form-label">
                <span class="x-red">*</span>病历</label>
            <div class="layui-input-inline">
        <textarea id="caseText" style="height:300px;width: 700px" name="text"
                  class="layui-input">${caseBean.text}</textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_email" class="layui-form-label">
                开药</label>
            <div class="">

                <div style="float: left">
                    <table id="medicineTable" class="layui-table">
                        <tr>
                            <th>药物</th>
                            <th>数量</th>
                            <th>审核状态</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach var="item" items="${caseMedicineList}" varStatus="xh">
                            <tr>
                                <td>${item.medicineName}</td>
                                <td>${item.quantity}</td>
                                <td>${item.audit eq "1"?"审核通过":""}
                                        ${item.audit eq "0"?"待审核":""}
                                        ${item.audit eq "-1"?"审核未通过":""}
                                </td>
                                <td>
                                    <button type="button" onclick="toDeleteMedicine(${item.id},this)" class="layui-btn layui-btn-danger">删除</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div style="float: left;margin-left: 30px">
                    选择药物：<select id="medicineName">
                    <c:forEach var="item" items="${medicineList}">
                        <option value="${item.name}:${item.audit}" >${item.name}${item.audit==0?"(需审核)":""}</option>
                    </c:forEach>
                </select>
                    选择数量：<input id="medicineQuantity" class="layui-input"/>

                    <button type="button" onclick="toAddMedicine(${caseBean.id})" class="layui-btn">添加药物</button>
                </div>
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

        if (caseText.indexOf(now) == -1) {
            caseText = caseText + "\n--------------" + now + "--------------\n"
            $("#caseText").text(caseText);
        }

        toDeleteMedicine = function (id, trObject) {
            if (!confirm("确定删除？")){
                return
            }

            $.post("CaseMedicineAction.action",
                {
                    "id": id,
                    "doMethod": "delete"
                }, function (result) {
                    $(trObject).parent().parent().remove();
                });
        }

        toAddMedicine = function (caseId) {
            var medicineQuantity = $('#medicineQuantity').val();
            if (medicineQuantity.length <= 0 && medicineQuantity == "") {
                alert("请输入药物数量")
                return
            }

            var options = $("#medicineName option:selected");
            var medicineName = options.text();
            var audit1 = options.val().split(":")[1]
            
            if (medicineName.indexOf("(需审核)")!=-1){
                medicineName=medicineName.replace("(需审核)","")
            }

            audit = 0;
            if (audit1 == 1) {
                audit = 1;
            }

            $.post("CaseMedicineAction.action",
                {
                    "caseId": caseId,
                    "medicineName": medicineName,
                    "quantity": medicineQuantity,
                    "audit": audit,
                    "doMethod": "add"
                }, function (result) {
                    console.log(result)
                    id = result.id
                    var auditText = "待审核";
                    console.log(audit)
                    if (audit == 1) {
                        auditText = "审核通过";
                    }
                    var htmlText = "<tr>\n" +
                        "                            <td>" + medicineName + "</td>\n" +
                        "                            <td>" + medicineQuantity + "</td>\n" +
                        "                            <td>" + auditText +
                        "                            </td>\n" +
                        "                            <td>\n" +
                        "                                <button type=\"button\" class=\"layui-btn layui-btn-danger\" onclick=\"toDeleteMedicine(" + id + ",this)\">删除</button>\n" +
                        "                            </td>\n" +
                        "                        </tr>";

                    $("#medicineTable tr:last").after(htmlText);
                });
        }

    });

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