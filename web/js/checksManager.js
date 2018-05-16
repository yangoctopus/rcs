/*
通过加载事件，发送ajax请求，加载用户列表
*/
window.onload=function(){
    findMess();
}

function findMess(){

    $("#dg").datagrid({
        url: "findAllChecks.action",
        fitColumns: true,
        singleSelect: true,
        pagination: true,
        toolbar:"#toolbar",
        columns: [[
            {field:'checkid',title:'检查单号',width:150},
            {field:'checkdate',title:'检查日期',width:90},
            {field:'field',title:'属性',width:100},
            {field:'problem',title:'问题',width:100},
            {field:'paying',title:'赔付',width:80},
            {field:'username',title:'检查人员',width:150},
            {field:'rentid',title:'出租单号',width:80},
        ]]

    });

}


var url;
function editRent(){
	$("#rid").textbox('textbox').attr({"readonly":true});
    var row = $('#dg').datagrid('getSelected');
    if (row){
        $('#dlg').dialog('open').dialog('setTitle','修改出租单').panel("move",{top:15});
        $('#fm').form('load',row);
        url = 'updateRents.action';
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

