// **** 权限列表 ****

//缓存当前操作的节点
var curNodeCache;

$(document).ready(function(){
	//加载根节点数据
	loadTree();
});

/**
 * 加载根节点数据
 */
function loadTree() {
	$('#treeData').tree({
	    url : getCtx() + "/sms/pms/permission/queryRolePermissionList?roleId=" + $("#roleId").val(),
	    checkbox : true,
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
 * 选某节点后，初始化列表当前节点信息，及子权限列表的加载
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
}
/**
 * 保存权限分配
 */
function distribute() {
	var permissions = $("#treeData").tree("getChecked", ["checked", "indeterminate"]);
	console.log(permissions);
	if (permissions.length == 0) {
		fmsg("请至少选择一个权限！");
		return;
	}
	var permissionIds = "";
	$.each(permissions, function(i, o) {
		if (o.id == "-1")
			return true;
		if (permissionIds != "")
			permissionIds += ",";
		permissionIds += o.id;
	});
	
	july.ajax({
		url : getCtx() + "/sms/pms/permission/distribute",
		data : {
			roleId : $("#roleId").val(),
			permissionIds : permissionIds
		},
		prFlag : "distribute",
		success : function(result) {
			if (result.code == "100") {
				fmsg("保存权限分配成功！");
				//重新加载根节点数据
				loadTree();
			} else {
				fmsg("保存权限分配失败！");
			}
		},
		error : function() {
			fmsg("保存权限分配失败！");
		}
	});
}






