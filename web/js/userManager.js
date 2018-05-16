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
        url: "findKey.action?keywords=" + keywords,
        fitColumns: true,
        singleSelect: true,
        pagination: true,
        toolbar:"#toolbar",
        columns: [[
            {field: 'username', title: '用户名', width: 100},
            {field: 'identity', title: '身份证', width: 150},
            {field: 'fullname', title: '姓名', width: 100, align: 'right'},
            {field: 'sex', title: '性别', width: 50, align: 'right'},
            {field: 'address', title: '地址', width: 100, align: 'right'},
            {field: 'phone', title: '电话', width: 100, align: 'right'},
            {field: 'position', title: '职业', width: 100, align: 'right'},
            {field: 'username', title: '权限', width: 100, align: 'right'}
        ]]
    });

}

var url;
function newUser(){
    $('#dlg').dialog('open').dialog('setTitle','添加角色').panel("move",{top:15});
    $('#fm').form('clear');
    url = 'saveUsers.action';
    /*
	 * 加载角色下拉列表框中的信息
	 * */
    $('#cc').combobox({
        url:'loadAllRolesList.action',
        valueField:'roleid',
        textField:'rolename',
        multiple:true
    });

}

function saveUser(){
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
function editUser(){
    var row=$("#dg").datagrid('getSelected');

    url="updateUsers.action";
    if(row){

        //打开添加角色信息的对话框
        $("#dlg").dialog("open").dialog('setTitle','编辑角色').panel("move",{top:15});
        /*
		 * 加载角色下拉列表框中的信息
		 * */
        $('#cc').combobox({
            url:'loadAllRolesList.action',
            valueField:'roleid',
            textField:'rolename',
            multiple:true
        });


        //发送ajax请求，获得用户的角色id集合
        $.post("loadUserRole.action","username="+row.username,function(data){
            $('#cc').combobox('setValues', data);

        });
        $('#fm').form('load',row);


    }

}

/*删除选中行*/
function delUser(){

    //获得datagrid控件中选中的行
    var row = $('#dg').datagrid('getSelected');
    if (row){
        url = 'delUsers.action';
        $.post(url,row);
        $('#dg').datagrid('reload');
    }

}

