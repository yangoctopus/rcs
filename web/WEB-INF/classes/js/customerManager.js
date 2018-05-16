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
        url: "findCustomerKey.action?keywords=" + keywords,
        fitColumns: true,
        singleSelect: true,
        pagination: true,
        toolbar:"#toolbar",
        columns: [[
            {field: 'identity', title: '客户编号', width: 100},
            {field: 'custname', title: '客户名称', width: 150},
            {field: 'sex', title:'客户性别', width: 100, align: 'right'},
            {field: 'address', title: '客户地址', width: 100, align: 'right'},
            {field: 'phone', title: '客户电话', width: 100, align: 'right'},
            {field: 'career', title: '客户职业', width: 100, align: 'right'},
        ]]
    });

}
var url;
function newCustomer(){
    $('#dlg').dialog('open').dialog('setTitle','添加角色').panel("move",{top:15});
    $('#fm').form('clear');
    $('#identity').textbox('textbox').attr('readonly',false);
    url = 'saveCustomer.action';
}

function saveCustomer(){
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
function editCustomer(){
    var row=$("#dg").datagrid('getSelected');
    if(row){
        //打开添加角色信息的对话框
        $("#dlg").dialog("open").dialog('setTitle','编辑角色');
        $('#fm').form('load',row);
        $('#identity').textbox('textbox').attr('readonly',true);
        url="updateCustomer.action";
    }

}

/*删除选中行*/
function delCustomer(){

    //获得datagrid控件中选中的行
    var row = $('#dg').datagrid('getSelected');
    if (row){
        url = 'delCustomer.action';
        $.post(url,row);
        $('#dg').datagrid('reload');
    }

}

