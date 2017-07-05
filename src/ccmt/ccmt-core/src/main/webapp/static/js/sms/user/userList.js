// **** 用户列表 ****

//数据列表表格
var $dataTable;

$(document).ready(function(){
	$dataTable = $("#dataTable");
	
	//初始化数据
	initData();
});

function ccmtTableBtn(op, name, click, title) {
	
}

/**
 * 初始化数据
 */
function initData() {
	$dataTable.remexJqGrid({
		url : "/sms/user/queryList",
		colModel : [
           {name : "id", label : "ID",},
           {name : "username", label : "用户名", editable : true},
           {name : "name", label : "姓名", editable : true},
           {name : "sex", label : "性别", editable : true, edittype : "select", editoptions : {value : "0:男;1:女"}},
           {name : "birthday", label : "生日", editable : true},
           {name : "status", label : "状态",},
           {label : "操作", viewable : false, formatter:function(cellvalue, options, rowObject) {
        	   var opDiv = '';
        	   opDiv += '<button onclick="toView(\'' + options.rowId + '\')" class="btn btn-info btn-xs" title="详情">详</button>';
        	   opDiv += '<button onclick="toEdit(\'' + options.rowId + '\')" class="btn btn-success btn-xs" title="修改">改</button>';
        	   opDiv += '<button onclick="" class="btn btn-danger btn-xs" title="禁用">禁</button>';
        	   return opDiv;
           }},
		],
		pager : "#dataPage",
		caption : "用户列表",
	});
}

/**
 * 打开详情界面
 */
function toView(rowId) {
	$dataTable.remexJgToView(rowId);
}

/**
 * 打开新增界面
 */
function toAdd() {
	$dataTable.remexJgToAdd({
		url : "/sms/user/add"
	});
}

/**
 * 打开修改界面
 */
function toEdit(rowId) {
	$dataTable.remexJgToEdit(rowId, {
		url : "/sms/user/update"
	});
}
