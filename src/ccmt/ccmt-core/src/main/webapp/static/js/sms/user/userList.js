// **** 用户列表 ****

//数据列表模板
var tempDataList;

$(document).ready(function(){
	//模板提取
	tempDataList = $("#tempDataList").html();
	$("#tempDataList").remove();
	
	//查询
	search();
});

/**
 * 查询
 */
function search() {
	$("#tableDataList").empty();
	
	july.ajax({
		url : getCtx() + "/sms/user/queryList",
		data : {},
		success : function(result) {
			if (result.code == "100") {
				var html = juicer(tempDataList, {dataList : result.data.data});
				$("#tableDataList").html(html);
			} else {
				emsg("查询失败！");
			}
		}
	});
}

/**
 * 改变状态
 */
function changeStatus(id, status) {
	alert("功能暂未开通！");
//	july.ajax({
//		url : getCtx() + "/sms/user/changeStatus",
//		data : {
//			id : id,
//			status : status,
//		},
//		success : function(result) {
//			
//		}
//	});
}









