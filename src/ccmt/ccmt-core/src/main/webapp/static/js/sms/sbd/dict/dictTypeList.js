// **** 数据字典类型列表 ****

//数据缓存
var dataCache;
//当前正在操作的数据字典类型下标
var opCurTypeIndex;
//数据列表模板
var tempDataList;
var tempDictList;

$(document).ready(function(){
	//模板提取
	tempDataList = $("#tempDataList").html();
	$("#tempDataList").remove();
	tempDictList = $("#tempDictList").html();
	$("#tempDictList").remove();
	
	//查询
	search();
});

/**
 * 查询
 */
function search() {
	$('#pageBar').remexPage({
		url : getCtx() + "/sms/sbd/dictType/queryList",
	    data : function() {
	    	return $("#searchForm").serializeMap();
	    },
		before : function() {
			$("#tableDataList").empty();
		},
	    callback: function(result, pagination){
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
			data.statusStr = ccmtDd.tran(data.status, 'SMS_DICT_TYPE_STATUS');
		});
	}
}

/**
 * 到数据字典界面
 * @param typeCode
 */
function toDict(typeCode) {
	location.href = getCtx() + "/sms/sbd/dict/toList";
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
            	url : getCtx() + "/sms/sbd/dictType/add",
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
            return false;
        }
	});
}

/**
 * 打开数据字典界面
 */
function openDict(index) {
	opCurTypeIndex = index;
	$("#dictPanelTitle").text(dataCache[opCurTypeIndex].typeName + " - " + dataCache[opCurTypeIndex].typeCode);
	$("#ccmtShade").show();
	$("#dictPanel").show();
	queryDictList();
}

/**
 * 关闭数据字典界面
 */
function closeListDict() {
	$("#ccmtShade").hide();
	$("#dictPanel").hide();
}

/**
 * 查询数据字典列表
 */
function queryDictList() {
	july.ajax({
		url : getCtx() + "/sms/sbd/dict/queryList",
		data : {
			typeCode : dataCache[opCurTypeIndex].typeCode,
		},
		success : function(result) {
			if (result.code == "100") {
	    		var html = juicer(tempDictList, {dataList : result.data});
				$("#dictTableDataList").html(html);
	    	} else {
	    		fmsg("查询失败！");
	    	}
		},
		error : function() {
	    	fmsg("数据字典列表查询失败！");
	    }
	});
}

/**
 * 打开数据字典新增界面
 */
function openAddDict() {
	$("#addDictTypeCode").val(dataCache[opCurTypeIndex].typeCode);
	$("#addDictTypeName").val(dataCache[opCurTypeIndex].typeName);
	$("#ccmtShadeTwo").show();
	$("#addDictPanel").show();
}

/**
 * 关闭数据字典新增界面
 */
function closeAddDict() {
	$("#ccmtShadeTwo").hide();
	$("#addDictPanel").hide();
}

/**
 * 新增数据字典
 */
function addDict() {
	$("#addDictForm").ccmtValidate({
		submitHandler: function(form){  
            july.ajax({
            	url : getCtx() + "/sms/sbd/dict/add",
            	data : $("#addDictForm").serialize(),
            	prFlag : "addDict",
            	success : function(result) {
            		if (result.code == "100") {
            			rmsg("新增成功！");
            			closeAddDict();
            			queryDictList();
            		} else {
            			fmsg("新增失败！");
            		}
            	},
            	error : function() {
            		fmsg("新增失败！");
            	}
            });
            return false;
        }
	});
}