<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>数据字典类型列表</title>
	
	<link href="${ctx}/static/plugins/jquery-ui/css/jquery-ui.custom.grey.css" rel="stylesheet">
	<link href="${ctx}/static/plugins/jqGrid-4.4.3/css/ui.jqgrid.css" rel="stylesheet">
</head>
<body>
	
	<!-- 数据列表 -->
	<table id="dataTable"></table>
	<!-- 数据列表分页 -->
	<div id="dataPage"></div>
	
	<script type="text/javascript" src="${ctx}/static/plugins/jquery-ui/js/jquery-ui-1.10.4.custom.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/js/plugins/jquery-migrate-1.1.0.js"></script>
	<script type="text/javascript" src="${ctx}/static/plugins/jqGrid-4.4.3/js/i18n/grid.locale-cn.js"></script>
	<script type="text/javascript" src="${ctx}/static/plugins/jqGrid-4.4.3/js/jquery.jqGrid.src.js"></script>
	<script type="text/javascript" src="${ctx}/static/js/common/jqGrid-common.js"></script>
	<script type="text/javascript" src="${ctx}/static/js/sm/sbd/dict/dictTypeList.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
	    $("#dataTable").ccmtJqGrid({
	        url : getCtx() + "/sm/sbd/dict/type/queryList",
	        colNames : ["类型代码", "类型名称", "状态", "备注", "修改时间"],
	        colModel : [
	            {name : "typeCode"},
	            {name : "typeName"},
	            {name : "status"},
	            {name : "remark"},
	            {name : "modifyTime"},
	        ],
	        pager : $('#dataPage')
	    });
	});
	</script>
</body>
</html>







