<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ccmt.tld" prefix="ccmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色分配</title>
	<link rel="stylesheet" type="text/css" href="${ctx}/static/plugins/jquery-easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/static/plugins/jquery-easyui/themes/icon.css">
    <script type="text/javascript" src="${ctx}/static/plugins/jquery-easyui/jquery.easyui.min.js"></script>
</head>
<body>
	<input type="hidden" id="userId" value="${userId}">

   	<div class="row">
		<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="x_panel">
				<div class="x_title">
                   	<h2>角色详情<small></small></h2>
              		<div class="clearfix"></div>
               	</div>
                  	
               	<div class="x_content">
               		<div class="ccmt-tree-left">
				        <ul id="treeData"></ul>
				        
				        <div class="row">
							<div class="col-md-12 col-sm-12 col-xs-12 col-md-offset-4">
								<button onclick="distribute()" class="btn btn-primary"> 保   存 </button>
							</div>
						</div>
				    </div>
               	
                  	<div class="ccmt-tree-right">
						<div class="row csb-row">
							<div id="curNodeInfo">
								<div class="col-md-3 col-sm-12 col-xs-12 form-group">
									<span class="csb-label">当前节点：</span>
									<input name="name" type="text" readonly="readonly" class="form-control csb-control"/>
								</div>
								<div class="col-md-3 col-sm-12 col-xs-12 form-group">
									<span class="csb-label">状态：</span>
									<input name="status" type="text" readonly="readonly" class="form-control csb-control"/>
								</div>
								<div class="col-md-3 col-sm-12 col-xs-12 form-group">
									<span class="csb-label">备注：</span>
									<input name="remark" type="text" readonly="readonly" class="form-control csb-control"/>
								</div>
							</div>
						</div>
                  	</div>
				</div>
			</div>
		</div>
    </div>
    
	<script type="text/javascript" src="${ctx}/static/js/sms/pms/roleDistribute.js"></script>
</body>
</html>