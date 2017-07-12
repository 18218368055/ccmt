<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ccmt.tld" prefix="ccmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权限列表</title>
	<link rel="stylesheet" type="text/css" href="${ctx}/static/plugins/jquery-easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/static/plugins/jquery-easyui/themes/icon.css">
    <script type="text/javascript" src="${ctx}/static/plugins/jquery-easyui/jquery.easyui.min.js"></script>
</head>
<body>
   	<div class="row">
		<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="x_panel">
				<div class="x_title">
                    <h2>权限列表<small></small></h2>
                   	<div class="clearfix"></div>
               	</div>
                  	
                <div class="x_content">
                	<div class="ccmt-tree-left">
				        <ul id="treeData"></ul>
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
									<span class="csb-label">权限代码：</span>
									<input name="code" type="text" readonly="readonly" class="form-control csb-control"/>
								</div>
								<div class="col-md-3 col-sm-12 col-xs-12 form-group">
									<span class="csb-label">URL：</span>
									<input name="url" type="text" readonly="readonly" class="form-control csb-control"/>
								</div>
								<div class="col-md-3 col-sm-12 col-xs-12 form-group">
									<span class="csb-label">备注：</span>
									<input name="remark" type="text" readonly="readonly" class="form-control csb-control"/>
								</div>
							</div>
						</div>
						
						<div class="row csb-row">
							<div class="col-md-12 col-sm-12 col-xs-12 col-md-offset-4">
								<button onclick="openAdd()" class="btn btn-success ccmt-btn"> 新   增 </button>
							</div>
						</div>
						
						<div class="row dtb-row">
							<table class="table table-bordered">
								<thead>
                          			<tr class="">
                          				<th>名称</th>
                          				<th>权限代码</th>
                          				<th>URL</th>
                          				<th>备注</th>
                          				<th>状态</th>
                          				<th>操作</th>
                          			</tr>
                        		</thead>
                        		<tbody id="tableDataList">
                        			<script type="text/template" id="tempDataList">
                        				{@each dataList as data, index}
											<tr>
												<td>{{data.name}}</td>
												<td>{{data.code}}</td>
												<td>{{data.url}}</td>
												<td>{{data.remark}}</td>
												<td>{@out ccmtDd.tran(data.status, 'SMS_ROLE_STATUS')}</td>
												<td>
													<button onclick="" class="btn btn-info btn-xs" title="修改">改</button>
													{@if data.status == '1'}
														<button onclick="changeStatus('{{data.id}}', '0')" class="btn btn-danger btn-xs" title="禁用">禁</button>
													{@else}
														<button onclick="changeStatus('{{data.id}}', '1')" class="btn btn-danger btn-xs" title="启用">启</button>
													{@/if}
													<button onclick="" class="btn btn-primary btn-xs" title="权限分配">权</button>
												</td>
											</tr>
										{@/each}
                        			</script>
								</tbody>
                       		</table>
						</div>
                  	</div>
				</div>
			</div>
		</div>
    </div>
    
    <!-- 遮罩层 -->
	<div id="ccmtShade" class="ccmt-shade"></div>
	
    <!-- 新增界面 -->
	<div id="addPanel" class="ccmt-shade-dialog">
		<div class="row">
			<div class="x_panel">
				<div class="x_title">
                   	<h2>新增权限<small></small></h2>
                	<div class="clearfix"></div>
           		</div>
           		
	           	<div class="x_content efc-content">
					<form id="addForm" class="form-horizontal form-label-left">
						<div class="item form-group efc-row">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">
								父节点<span class="red">*</span>：
							</label>
	                        <div class="col-md-5 col-sm-6 col-xs-12">
	                        	<input name="parentName" readonly="readonly" class="form-control col-md-7 col-xs-12" type="text">
	                        	<input type="hidden" name="parentId">
	                        </div>
							<div class="alert"></div>
						</div>
						<div class="item form-group efc-row">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">
								权限名称<span class="red">*</span>：
							</label>
	                        <div class="col-md-5 col-sm-6 col-xs-12">
	                        	<input name="name" class="required form-control col-md-7 col-xs-12" type="text">
	                        </div>
							<div class="alert"></div>
						</div>
						<div class="item form-group efc-row">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">
								权限代码<span class="red">*</span>：
							</label>
	                        <div class="col-md-5 col-sm-6 col-xs-12">
	                        	<input name="code" class="required form-control col-md-7 col-xs-12" type="text">
	                        </div>
							<div class="alert"></div>
						</div>
						<div class="item form-group efc-row">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">
								URL&nbsp;：
							</label>
	                        <div class="col-md-5 col-sm-6 col-xs-12">
	                        	<input name="url" class="form-control col-md-7 col-xs-12" type="text">
	                        </div>
							<div class="alert"></div>
						</div>
						<div class="item form-group efc-row">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">
								状态&nbsp;：
							</label>
	                        <div class="col-md-5 col-sm-6 col-xs-12">
	                        	<input value="禁用" readonly="readonly" class="form-control col-md-7 col-xs-12" type="text">
	                        	<input name="status" value="0" type="hidden"/>
	                        </div>
						</div>
						<div class="item form-group efc-row">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">
								备注&nbsp;：
							</label>
	                        <div class="col-md-5 col-sm-6 col-xs-12">
	                        	<input class="form-control col-md-7 col-xs-12" name="remark" type="text">
	                        </div>
						</div>
						
						<div class="ln_solid"></div>
						
						<div class="form-group">
                        <div class="col-md-6 col-md-offset-3">
                        	<button onclick="add()" class="btn btn-primary ccmt-btn"> 提   交 </button>
                        	<button onclick="closeAdd()" class="btn btn-primary ccmt-btn" type="button"> 取   消 </button>
                        </div>
                      </div>
					</form>                  		
            	</div>
           	</div>
		</div>
	</div>
    
	<script type="text/javascript" src="${ctx}/static/js/sms/pms/permissionList.js"></script>
</body>
</html>