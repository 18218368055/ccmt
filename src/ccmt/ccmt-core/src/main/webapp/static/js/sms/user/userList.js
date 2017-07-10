// **** 用户列表 ****

//数据缓存
var dataCache;
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
	    callback : function(result, pagination){
	    	var dataList;
	    	if (result.code == "100") {
	    		dataList = result.data.data || [];
	    		//数据统一转换
	    		dataTran(dataList);
	    		//模板渲染
	    		var html = juicer(tempDataList, {dataList : dataList});
	    		$("#tableDataList").html(html);
	    		
	    	} else {
	    		fmsg("查询失败！");
	    	}
	    	dataCache = dataList;
	    }
	});
}

/**
 * 数据统一转换
 */
function dataTran(dataList) {
	if (dataList) {
		$.each(dataList, function(i, data) {
			data.statusStr = ccmtDd.tran(data.status, 'SMS_USER_STATUS');
			data.sexStr = ccmtDd.tran(data.sex, 'SEX');
			data.birthdayStr = new Date(data.birthday).format("yyyy-MM-dd");
			data.createTimeStr = new Date(data.createTime).format("yyyy-MM-dd hh:mm");
		});
	}
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

/**
 * 打开详情界面
 */
function openView(index) {
	$("#ccmtShade").show();
	$("#viewPanel").show();
	
	var data = dataCache[index];
	$("#viewPanel").valsByName({
		setType : "text",
		data : data,
	});
//	$("#vpUsername").text(data.username);
//	$("#vpName").text(data.name);
//	$("#vpStatus").text(ccmtDd.tran(data.status, 'SMS_USER_STATUS'));
//	$("#vpBirthday").text(data.birthday);
//	$("#vpSex").text(ccmtDd.tran(data.sex, 'SEX'));
//	$("#vpCreateTime").text(data.createTime);
}

/**
 * 关闭详情界面
 */
function closeView() {
	$("#ccmtShade").hide();
	$("#viewPanel").hide();
}








