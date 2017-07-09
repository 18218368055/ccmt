// **** 数据字典列表 ****

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
	$("#tableDataList").empty();
	
	july.ajax({
		url : getCtx() + "/sms/sbd/dict/queryList",
	    data : $("#searchForm").serialize(),
	    success : function(result) {
	    	if (result.code == "100") {
	    		dataCache = result.data || [];
	    		var html = juicer(tempDataList, {dataList : result.data});
				$("#tableDataList").html(html);
	    	} else {
	    		fmsg("查询失败！");
	    	}
	    },
	    error : function() {
	    	fmsg("查询失败！");
	    }
	});
}

/**
 * 打开新增界面
 */
function openAdd() {
	$("#ccmtShade").show();
	$("#addPanel").show();
}

/**
 * 关闭新增界面
 */
function closeAdd() {
	$("#ccmtShade").hide();
	$("#addPanel").hide();
}

/**
 * 新增
 */
function add() {
	$("#addForm").ccmtValidate({
		submitHandler: function(form){  
            july.ajax({
            	url : getCtx() + "/sms/sbd/dict/add",
            	data : $("#addForm").serialize(),
            	prFlag : "add",
            	success : function(result) {
            		if (result.code == "100") {
            			rmsg("新增成功！");
            			closeAdd();
            			search()
            		} else {
            			fmsg("新增失败！");
            		}
            	},
            	error : function() {
            		fmsg("新增失败！");
            	}
            });
        }
	});
}