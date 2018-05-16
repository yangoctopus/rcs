<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
        <meta charset="UTF-8">
        <title>检查单管理</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/color.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css">
        
        <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
    </head>
    <body>
    
       <table id="dg" style="width: 100%;height:500px;"></table>
       
        <div id="toolbar">
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="editCheck()">修改检查单</a>
        </div>
        
        <div id="dlg" class="easyui-dialog" style="width:500px;"
                closed="true" buttons="#dlg-buttons" shadow="false">
            <form id="fm" method="post" novalidate style="margin:0;padding:20px 50px">
                <div style="margin-bottom:20px;font-size:14px;border-bottom:1px solid #ccc">检查单信息</div>
                <div style="margin-bottom:10px">
                    <input id="ckid" name="checkid" class="easyui-textbox" required="true" label="检查单号:" style="width:100%">
                </div>
                <div style="margin-bottom:10px">
                    <input name="checkdate" class="easyui-datetimebox" data-options="formatter:myformatter,parser:myparser" required="true" label="检测日期:" style="width:100%">
                </div>
                <div style="margin-bottom:10px">
                    <input name="field" class="easyui-textbox" required="true" label="检测属性:" style="width:100%">
                </div>
                <div style="margin-bottom:10px">
                    <input name="paying" class="easyui-textbox" required="true" label="应赔付:" style="width:100%">
                </div>
                <div style="margin-bottom:10px">
                    <input name="rentid" class="easyui-textbox" required="true" label="出租单号:" style="width:100%">
                </div>
                <div style="margin-bottom:10px">
                    <input name="username" class="easyui-textbox" required="true" label="业务人员:" style="width:100%">
                </div>
                <div style="margin-bottom:10px">
                    <input name="problem" class="easyui-textbox" required="true" label="车辆问题:" multiline="true"  style="width:100%;height: 100px">
                </div>
            </form>
        </div>
        <div id="dlg-buttons">
            <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveRent()" style="width:90px">保存</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
        </div>
        
        <script type="text/javascript">
        $(function(){
	        $("#dg").datagrid({
	            title:'检查单列表',
	            singleSelect:true,
	            fitColumns:true,
	            pagination:true,
	    		rownumbers:true,
	    		toolbar:'#toolbar',
	            url:'findAllChecks.action',
	            columns:[[
	                {field:'checkid',title:'检查单号',width:150},
	                {field:'checkdate',title:'检测日期',width:120},
	                {field:'field',title:'检测属性',width:100},
	                {field:'problem',title:'问题',width:100},
	                {field:'paying',title:'应赔付',width:80},
	                {field:'username',title:'处理业务员',width:80},
	                {field:'rentid',title:'相关出租单号',width:150},
	            ]]
	        });
        });
        
        //=========================================================================
	        
            var url;
            function editCheck(){
            	$("#ckid").textbox('textbox').attr({"readonly":true});
                var row = $('#dg').datagrid('getSelected');
                if (row){
                    $('#dlg').dialog('open').dialog('setTitle','修改检测单').panel("move",{top:15});
	                $('#fm').form('load',row);
                    url = 'updateChecks.action';
                }
            }
            function saveRent(){
                $('#fm').form('submit',{
                    url: url,
                    onSubmit: function(){
                        return $(this).form('validate');
                    },
                    success: function(result){
                        if (result.errorMsg){
                            $.messager.show({
                                title: 'Error',
                                msg: result.errorMsg
                            });
                        } else {
                            $('#dlg').dialog('close');        // close the dialog
                            $('#dg').datagrid('reload');    // reload the user data
                        }
                    }
                });
            };
            
            function myformatter(date){
                var y = date.getFullYear();
                var m = date.getMonth()+1;
                var d = date.getDate();
                return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
            }
            function myparser(s){
                if (!s) return new Date();
                var ss = (s.split('-'));
                var y = parseInt(ss[0],10);
                var m = parseInt(ss[1],10);
                var d = parseInt(ss[2],10);
                if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
                    return new Date(y,m-1,d);
                } else {
                    return new Date();
                }
            }
        </script>
    </body>
    </html>