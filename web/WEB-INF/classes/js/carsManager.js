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
        url: "findCarsKey.action?keywords=" + keywords,
        fitColumns: true,
        singleSelect: true,
        pagination: true,
        toolbar:"#toolbar",
        columns: [[
            {field: 'carnumber', title: '车辆号牌', width: 100},
            {field: 'cartype', title: '车辆类型', width: 150},
            {field: 'price', title:'车辆价格', width: 100, align: 'right'},
            {field: 'rentprice', title: '出租价格', width: 100, align: 'right'},
            {field: 'deposit', title: '押金', width: 100, align: 'right'},
            {field: 'isrenting', title: '出租状态', width: 100, align: 'right'},
        ]],
        view: detailview,
        detailFormatter: function(rowIndex, data){

            return "<table style='width:50%;border:0'>" +
                "<tr><td rowspan='2' style='width:35%;border:0'>" +
                "<img src='"+data.carimg+"' width=100  hegiht=100/></td>" +
                "<td>颜色:"+data.color+"</td>" +
                "</tr><tr>" +
                "<td style='width:35%;border:0'>" +
                "描述:"+data.description+"</td>" +
                "</tr></table>";

        }

    });

}

/*
 * uploadImg 发送图片上传请求
 * */
$(document).ready(function () {

    $("#mf").filebox({

        onChange: function (n,o) {

            $('#fm').form('submit',{
                url: 'uploadCarImg.action',
                onSubmit: function(){
                    return true;
                },
                success: function(result){
                    //将字符串，转化为json对象
                    result=JSON.parse(result);

                    if (result.errorMsg){
                        $.messager.show({//弹出消息框
                            title: 'Error',
                            msg: result.errorMsg
                        });
                    } else{

                        //alert(result.path);
                        //回显图片信息
                        $("#img").attr("src",result.path);
                        //将图片的路径保存到隐藏域
                        $("#carimg").val(result.path);
                    }
                }
            });

        }

    });

});
var url;
function newCars(){
    $('#dlg').dialog('open').dialog('setTitle','添加车辆').panel("move",{top:15});
    $('#fm').form('clear');
    $("#img").attr("src","");
    $('#identity').textbox('textbox').attr('readonly',false);
    url = 'saveCars.action';
}

function saveCars(){
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
function editCars(){
    var row=$("#dg").datagrid('getSelected');
    if(row){
        //打开添加角色信息的对话框
        $("#dlg").dialog("open").dialog('setTitle','编辑角色');
        $('#fm').form('load',row);
        $("#img").attr("src",row.carimg);
        $('#identity').textbox('textbox').attr('readonly',true);
        url="updateCars.action";
    }

}

/*删除选中行*/
function delCars(){

    //获得datagrid控件中选中的行
    var row = $('#dg').datagrid('getSelected');
    if (row){
        url = 'delCars.action';
        $.post(url,row);
        $('#dg').datagrid('reload');
    }

}

