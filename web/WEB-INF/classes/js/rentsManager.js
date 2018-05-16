/*
通过加载事件，发送ajax请求，加载用户列表
*/
window.onload=function(){
    findMess();
}

function findMess(){
   var begindate=$("#begindate").val();
    var returndate=$("#returndate").val();
    $("#dg").datagrid({
        url: "findAllRents.action?begindate=" + begindate+"&returndate="+returndate,
        fitColumns: true,
        singleSelect: true,
        pagination: true,
        toolbar:"#toolbar",
        columns: [[
            {field:'rentid',title:'出租单号',width:150},
            {field:'price',title:'出租价格',width:90},
            {field:'begindate',title:'起租时间',width:100},
            {field:'returndate',title:'还车时间',width:100},
            {field:'rentflag',title:'车辆状态',width:80},
            {field:'custid',title:'客户编号',width:150},
            {field:'carid',title:'车牌号',width:80},
            {field:'username',title:'业务人员',width:80},
        ]]

    });

}

////////////////////////////////////////////////////////////////

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


/////////////////////////////////////////////////////


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

