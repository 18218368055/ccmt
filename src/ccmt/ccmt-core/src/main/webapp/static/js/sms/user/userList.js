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











/*

create table sm_dict (
	`id` int(11) not null auto_increment comment '主键',
	`code` varchar(50) not null comment '字典代码',
	`name` varchar(100) not null comment '字典名称',
	`type_code` varchar(50) not null comment '字典类型代码',
	`type_name` varchar(100) not null comment '字典类型名称',
	`status` int(1) not null comment '状态，0：禁用，1：启用',
	`sort` int(2) comment '排序',
	`remark` varchar(500) comment '备注',
	`creator` varchar(50) comment '创建人',
	`create_time` datetime default current_timestamp comment '创建时间',
	`modifier` varchar(50) comment '修改人',
	`modify_time` datetime comment '修改时间',
	primary key(`id`),
	index `type_code` (`type_code`),
	index `code` (`code`)
)
comment '数据字典表'
;





create table `sm_dict_type` (
	`id` int(11) not null auto_increment comment '主键',
	`type_code` varchar(50) not null comment '字典类型代码',
	`type_name` varchar(100) not null comment '字典类型名称',
	`status` int(1) not null comment '状态，0：禁用；1：启用',
	`remark` varchar(500) comment '备注',
	`creator` varchar(50) comment '创建人',
	`create_time` datetime default current_timestamp comment '创建时间',
	`modifier` varchar(50) comment '修改人',
	`modify_time` datetime comment '修改时间',
	primary key (`id`),
	unique index `type_code` (`type_code`)
)
comment='数据字典类型表'
;
*/