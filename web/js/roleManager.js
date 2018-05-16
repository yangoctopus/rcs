/*
通过加载事件，发送ajax请求，加载用户列表
*/
$(document).ready(function(){
    var keywords=$("#ss").val();
    $("#dg").datagrid({
        toolbar: [{
             text:   '<input type="text" class="easyui-textbox" id="ss" name="keywords" size="30" />'
        }, {
            iconCls: 'icon-search',
            text: '查询',
            handler: function () {
                findMess();
            }
        }]


    });
    findMess();
});

function findMess(){
   var keywords=$("#ss").val();
    $("#dg").datagrid({
        url: "findRolesKey.action?keywords=" + keywords,
        fitColumns: true,
        singleSelect: true,
        pagination: true,
        toolbar:"#toolbar",
        columns: [[
            {field: 'roleid', title: '职位编号', width: 100},
            {field: 'rolename', title: '职位名称', width: 150},
            {field: 'roledesc', title: '职位描述', width: 100, align: 'right'},
        ]]
    });

}
var url;
/*
打开角色授权的资源窗口
*/
function openPrivilege(){

    var row = $("#dg").datagrid('getSelected');

    //获得窗口的垂直位置
    var iTop = (window.screen.availHeight - 30 - 400) / 2;
    //获得窗口的水平位置
    var iLeft = (window.screen.availWidth - 10 - 400) / 2;
    if (row) {

        window.open("loadPrivilegeUI.action?roleid=" + row.roleid, ""
            , "location=no,height=400,width=400,status=no,left=" + iLeft + ",top=" + iTop);
    }

}
function newRole(){
    $('#dlg').dialog('open').dialog('setTitle','添加角色').panel("move",{top:15});
    $('#fm').form('clear');
    url = 'saveRoles.action';
}

function saveRole(){
    $("#fm").form('submit',{
        url:url,
        onSubmit:function(){
            return $(this).form('validate');
        },

        success:function(result){

            if (result.errorMsg){
                $.messager.show({//弹出消息框
                    title: 'Error',
                    msg: result.errorMsg
                });
            } else{
                $('#dlg').dialog('close');
                $('#dg').datagrid('reload');
            }
        }
    });
}

/*
打开角色编辑的对话框，实现角色信息的回显
*/
function editRole(){
    var row=$("#dg").datagrid('getSelected');
    if(row){
        //打开添加角色信息的对话框
        $("#dlg").dialog("open").dialog('setTitle','编辑角色');
        $('#fm').form('load',row);
        url="updateRoles.action?roleid="+row.roleid;
    }

}

/*删除选中行*/
function delRole() {

    //获得datagrid控件中选中的行
    var row = $('#dg').datagrid('getSelected');
    if (row) {
        url = 'delRoles.action';
        $.post(url, row);
        $('#dg').datagrid('reload');
    }



}