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
	$('#pageBar').remexPage({
		url : getCtx() + "/sms/user/queryList",
	    data : function() {
	    	return $("#searchForm").serializeMap();
	    },
		before : function() {
			$("#tableDataList").empty();
		},
	    callback: function(data, pagination){
	    	var html = juicer(tempDataList, {dataList : data});
			$("#tableDataList").html(html);
	    }
	});
}

/**
 * 改变状态
 */
function changeStatus(id, status) {
	var itMsg = status == 0 ? "禁用" : "启用";
	cfMsg("是否" + itMsg + "此用户？", function() {
		july.ajax({
			url : getCtx() + "/sms/user/changeUserStatus",
			data : {
				id : id,
				status : status
			},
			prFlag : "changeUserStatus",
			success : function(result) {
				if (result.code == "100") {
					rmsg(itMsg + "成功！");
					search();
				} else {
					fmsg(itMsg + "失败！");
				}
			}
		});
	});
}









