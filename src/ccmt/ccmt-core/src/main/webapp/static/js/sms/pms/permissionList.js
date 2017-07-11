// **** 角色列表 ****

//数据列表模板
var tempDataList;
//缓存当前操作的节点
var curNodeCache;

$(document).ready(function(){
	//模板提取
	tempDataList = $("#tempDataList").html();
	$("#tempDataList").remove();
	
	//加载根节点数据
	loadTree();
});

/**
 * 加载根节点数据
 */
function loadTree() {
	$('#treeData').tree({
	    url : getCtx() + "/sms/pms/permission/queryList",
	    formatter:function(node){
			return node.name;
		},
		loadFilter : function(data, parent) {
			//默认加入一个根节点
			var root = {
				id : "-1",
				name : "权限列表",
				status : "1",
				children : data
			};
			
			//缓存第一个节点及初始化一些信息
			curNodeCache = root;
			selNode(curNodeCache);
			
			return [root];
		},
		onClick : function(node) {
			selNode(node);
		}
	});
}

/**
 * 选某节点后，初始化列表当前节点信息，及子角色列表的加载
 * @param node
 */
function selNode(node) {
	curNodeCache = node;
	$("#curNodeInfo").valsByName({
		data : node,
		mapper : {
			status : ccmtDd.tran(node.status, 'SMS_PERMISSION_STATUS'),
		}
	});
	
	var children = node.children || [];
	//模板渲染
	var html = juicer(tempDataList, {dataList : children});
	$("#tableDataList").html(html);
}

/**
 * 打开新增界面
 */
function openAdd() {
	$("#addPanel").valsByName({
		mapper : {
			status : "0",
			parentId : curNodeCache.id,
			parentName : curNodeCache.name,
		},
	});
	
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
            	url : getCtx() + "/sms/pms/permission/add",
            	data : $("#addForm").serialize(),
            	prFlag : "add",
            	success : function(result) {
            		if (result.code == "100") {
            			rmsg("新增成功！");
            			closeAdd();
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







