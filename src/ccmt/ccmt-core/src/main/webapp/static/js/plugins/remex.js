// *** remex标准函数库 ***

var remex = {};

(function($) {
	
	//==================== jqGrid ====================
	/**
	 * 默认配置一些jqGrid的参数
	 */
	$.fn.remexJqGrid = function(ag) {
		ag = ag || {}
		//默认配置
		var aguse = {
			datatype : "json",  //请求数据返回的类型，可选json,xml,txt
			rowNum : 10,  //一页显示多少条
			rowList : [10, 20, 30],  //可供用户选择一页显示多少条
			mtype : "post",  //ajax提交方式。post或者post，默认get
			viewrecords : true,  //定义是否要显示总记录数
			autowidth : true,  //自动宽度
			height : 300,  //表格高度，可以是数字，像素值或者百分比
			jsonReader : {   //出参分页参数设置
				root : "data.data",
				page : "data.pageNum",
				total : "data.totalPage",
				records : "data.total",
			},
			prmNames : {  //入参分页参数设置
				page : "pageNum",
				rows : "pageSize"
			},
		}
		
		$.extend(aguse, ag);
		$(this).jqGrid(aguse);
	}
	
	
	//***** 一些暂时方案 *****
	/**
	 * 打开jqGrid自带的新增界面
	 */
	$.fn.remexJgToAdd =function(ag) {
		ag = ag || {};
		var aguse = {
			mtype: "post",
			onclickSubmit : function(params, postdata) {
				postdata.dataTable_id = "";
			},
			afterSubmit : function(response, postdata) {
				var result = $.parseJSON(response.responseText);
				if (result.code == "100") {
					alert("新增成功！");
					return [true, ""];
				} else {
					return [false, "新增失败！"];
				}
			},
			reloadAfterSubmit : true,
			closeAfterEdit : true,
			closeOnEscape : true,	
		}
		
		$.extend(aguse, ag);
		$(this).jqGrid("editGridRow", "new", aguse);
	}
	
	/**
	 * 打开jqGrid自带的详情界面
	 */
	$.fn.remexJgToView =function(rowId, ag) {
		ag = ag || {};
		var aguse = {
			closeOnEscape : true,	
		}
		
		$.extend(aguse, ag);
		$(this).jqGrid("viewGridRow", rowId, aguse);
	}
	
	/**
	 * 打开jqGrid自带的修改界面
	 */
	$.fn.remexJgToEdit =function(rowId, ag) {
		ag = ag || {};
		var aguse = {
			mtype: "post",
			afterSubmit : function(response, postdata) {
				var result = $.parseJSON(response.responseText);
				if (result.code == "100") {
					alert("修改成功！");
					return [true, ""];
				} else {
					return [false, "修改失败！"];
				}
			},
			reloadAfterSubmit : true,
			closeAfterEdit : true,
			closeOnEscape : true,	
			refreshstate : "current",
		}
		
		$.extend(aguse, ag);
		$(this).jqGrid("editGridRow", rowId, aguse);
	}
	
	//***** 一些暂时方案 End *****
	//==================== jqGrid End ====================
	
})(jQuery);









//================================= 备份 ==========================================

//function initEditUi() {
//	//新增按钮配置参数
//	var addOptions = {
//		url : "/sms/user/add",
//		mtype: "post",
//		onclickSubmit : function(params, postdata) {
//			postdata.dataTable_id = "";
//		},
//		afterSubmit : function(response, postdata) {
//			var result = $.parseJSON(response.responseText);
//			if (result.code == "100") {
//				alert("新增成功！");
//				return [true, ""];
//			} else {
//				return [false, "新增失败！"];
//			}
//		},
//		reloadAfterSubmit : true,
//		closeAfterEdit : true,
//    }
//	
//	//修改按钮配置参数
//	var editOptions = {
//		onclickSubmit: function(params, postdata) {
//			return false;
//		},
//		closeAfterEdit: true,
//	}
//	
//	//删除按钮配置参数
//    var delOptions = {
//        onclickSubmit: function(params, postdata) {
//        }
//    };
//	$("#dataTable").navGrid("#dataPage",
//		{}, //options
//		editOptions,
//        addOptions,
//        delOptions,
//        {} // search options
//	);
//}




