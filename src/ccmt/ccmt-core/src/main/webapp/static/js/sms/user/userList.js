// **** 用户列表 ****

$(document).ready(function(){
	//初始化数据
	initData();
	
	initEditUi();
});

/**
 * 初始化数据
 */
function initData() {
	$("#dataTable").remexJqGrid({
		url : "/sms/user/queryList",
		colModel : [
           {name : "id", label : "ID",},
           {name : "username", label : "用户名", editable : true},
           {name : "name", label : "姓名", editable : true},
           {name : "sex", label : "性别", editable : true},
           {name : "birthday", label : "生日",},
           {name : "status", label : "状态",},
		],
		pager : "#dataPage",
		caption : "用户列表",
	});
}

function initEditUi() {
	//新增按钮配置参数
	var addOptions = {
		url : "/sms/user/add",
		mtype: "POST",
		onclickSubmit : function(params, postdata) {
			postdata.dataTable_id = "";
		},
		afterSubmit : function(response, postdata) {
			console.log(response);
			postdata.id = 20000;
			alert("新增成功");
			return [true, 'error', '']
		},
		reloadAfterSubmit : false,
		closeAfterEdit : true,
    }
	
	//修改按钮配置参数
	var editOptions = {
		onclickSubmit: function(params, postdata) {
			return false;
		},
		closeAfterEdit: true,
	}
	
	//删除按钮配置参数
    var delOptions = {
        onclickSubmit: function(params, postdata) {
        }
    };
	$("#dataTable").navGrid("#dataPage",
		{}, //options
		editOptions,
        addOptions,
        delOptions,
        {} // search options
	);
}
