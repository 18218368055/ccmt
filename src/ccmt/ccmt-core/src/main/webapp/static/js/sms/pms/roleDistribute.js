// **** 角色列表 ****

$(document).ready(function(){
	//加载根节点数据
	loadTree();
});

/**
 * 加载根节点数据
 */
function loadTree() {
	$('#treeData').tree({
	    url : getCtx() + "/sms/pms/role/queryUserRoleList?userId=" + $("#userId").val(),
	    checkbox : true,
	    formatter:function(node){
			return node.name;
		},
		loadFilter : function(data, parent) {
			//默认加入一个根节点
			var root = {
				id : "-1",
				name : "角色列表",
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
			status : ccmtDd.tran(node.status, 'SMS_ROLE_STATUS'),
		}
	});
}

/**
 * 保存角色分配
 */
function distribute() {
	var roles = $("#treeData").tree("getChecked", "checked");
	if (roles.length == 0) {
		fmsg("请至少选择一个角色！");
		return;
	}
	var roleIds = "";
	$.each(roles, function(i, o) {
		if (o.id == "-1")
			return true;
		if (roleIds != "")
			roleIds += ",";
		roleIds += o.id;
	});
	
	july.ajax({
		url : getCtx() + "/sms/pms/role/distribute",
		data : {
			userId : $("#userId").val(),
			roleIds : roleIds
		},
		prFlag : "distribute",
		success : function(result) {
			if (result.code == "100") {
				fmsg("保存角色分配成功！");
				//重新加载根节点数据
				loadTree();
			} else {
				fmsg("保存角色分配失败！");
			}
		},
		error : function() {
			fmsg("保存角色分配失败！");
		}
	});
}







