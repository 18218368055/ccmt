<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>数据字典类型列表</title>
	
	<link href="${ctx}/static/plugins/gentelella/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
	<link href="${ctx}/static/css/pagination.css" rel="stylesheet">
</head>
<body>	
	<div class="">
	    <div class="row">
	    	<div class="col-md-12 col-sm-12 col-xs-12">
            	<div class="x_panel">
                	<div class="x_title">
                    	<h2>数据字典类型列表<small></small></h2>
                   		<div class="clearfix"></div>
                  	</div>
                  	
                  	<div class="x_content">
						<div class="table-responsive">
							<div class="row csb-row">
								<form id="queryForm">
									<div class="col-md-3 col-sm-12 col-xs-12 form-group">
										<span class="csb-label">类型代码：</span>
										<input name="typeCode" type="text" class="form-control csb-control"/>
									</div>
									<div class="col-md-3 col-sm-12 col-xs-12 form-group">
										<span class="csb-label">类型名称：</span>
										<input name="typeName" type="text" class="form-control csb-control"/>
									</div>
									<div class="col-md-3 col-sm-12 col-xs-12 form-group">
										<span class="csb-label">状态：</span>
										<select name="status" class="form-control csb-control">
											<option value="">全部</option>
											<option value="1">启用</option>
											<option value="0">禁用</option>
										</select>
									</div>
								</form>
							</div>
							<div class="row csb-row">
								<div class="col-md-12 col-sm-12 col-xs-12 col-md-offset-4">
									<button onclick="initSearch()" class="btn btn-success ccmt-btn"> 查   询 </button>
									<button onclick="resetForm()" class="btn btn-success ccmt-btn"> 重   置 </button>
									<button onclick="toAdd()" class="btn btn-primary ccmt-btn"> 新   增 </button>
								</div>
							</div>
							<div class="row dtb-row">
								<table class="table table-bordered">
									<thead>
	                          			<tr class="">
	                          				<th>类型代码</th>
	                          				<th>类型名称</th>
	                          				<th>状态</th>
	                          				<th>备注</th>
	                          				<th>操作</th>
	                          			</tr>
	                        		</thead>
	                        		<tbody id="tableDataList">
	                        			<script type="text/template" temp="tempDataList">
	                        				{@each dataList as dict}
			                        			<tr>
			                        				<td>{{dict.typeCode}}</td>
			                        				<td>{{dict.typeName}}</td>
			                        				<td>{@out ccmtDd.tran(dict.status, 'DICT_TYPE_STATUS')}</td>
			                        				<td>{{dict.remark}}</td>
													<td>
														<button class="btn btn-info btn-xs" title="数据字典">典</button>
			                          					{@if dict.status == 1}
			                          						<button onclick="changeDictTypeStatus('{{dict.id}}', 0)" class="btn btn-danger btn-xs" title="禁用">禁</button>
			                          					{@else}
			                          						<button onclick="changeDictTypeStatus('{{dict.id}}', 1)" class="btn btn-danger btn-xs" title="启用">启</button>
			                          					{@/if}
													</td>
			                        			</tr>
			                        		{@/each}
										</script>
	                        		</tbody>
								</table>
							</div>
							<div id="pageBar" class="row pgb-row">
							</div>
						</div>
                  	</div>
               	</div>
            </div>
	    </div>
	</div>
	
	<script type="text/javascript" src="${ctx}/static/js/plugins/juicer-asst.js"></script>
	<script type="text/javascript" src="${ctx}/static/js/sm/sbd/dict/dictTypeList.js"></script>
	<script type="text/javascript" src="${ctx}/static/js/plugins/pagination-asst.js"></script>
</body>
</html>







