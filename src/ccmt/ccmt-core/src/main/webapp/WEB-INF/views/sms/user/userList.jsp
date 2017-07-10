<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ccmt.tld" prefix="ccmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>
	<div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
                    	<h2>用户列表<small></small></h2>
                   		<div class="clearfix"></div>
                  	</div>
                  	
                  	<div class="x_content">
						<div class="row csb-row">
							<form id="searchForm">
								<div class="col-md-3 col-sm-12 col-xs-12 form-group">
									<span class="csb-label">用户名：</span>
									<input name="username" type="text" class="form-control csb-control"/>
								</div>
								<div class="col-md-3 col-sm-12 col-xs-12 form-group">
									<span class="csb-label">姓名：</span>
									<input name="name" type="text" class="form-control csb-control"/>
								</div>
								<div class="col-md-3 col-sm-12 col-xs-12 form-group">
									<span class="csb-label">状态：</span>
									<c:set var="dictList" value="${ccmt:dictGroup('SMS_USER_STATUS')}"/>
									<select name="status" class="form-control csb-control">
										<option value="">全部</option>
										<c:forEach var="dict" items="${dictList}">
											<option value="${dict.code}">${dict.name}</option>
										</c:forEach>
									</select>
								</div>
								<div class="col-md-3 col-sm-12 col-xs-12 form-group">
									<span class="csb-label">性别：</span>
									<c:set var="dictList" value="${ccmt:dictGroup('SEX')}"/>
									<select name="status" class="form-control csb-control">
										<option value="">全部</option>
										<c:forEach var="dict" items="${dictList}">
											<option value="${dict.code}">${dict.name}</option>
										</c:forEach>
									</select>
								</div>
							</form>
						</div>
						
						<div class="row csb-row">
							<div class="col-md-12 col-sm-12 col-xs-12 col-md-offset-4">
								<button onclick="search()" class="btn btn-success ccmt-btn"> 查   询 </button>
							</div>
						</div>
						
						<div class="row dtb-row">
							<table class="table table-bordered">
								<thead>
                          			<tr class="">
                          				<th>ID</th>
                          				<th>用户名</th>
                          				<th>姓名</th>
                          				<th>性别</th>
                          				<th>生日</th>
                          				<th>状态</th>
                          				<th>操作</th>
                          			</tr>
                        		</thead>
                        		<tbody id="tableDataList">
                       				<script type="text/template" id="tempDataList">
										{@each dataList as data, index}
											<tr>
												<td>{{data.id}}</td>
												<td>{{data.username}}</td>
												<td>{{data.name}}</td>
												<td>{{data.sexStr}}</td>
												<td>{{data.birthdayStr}}</td>
												<td>{{data.statusStr}}</td>
												<td>
													<button onclick="openView({{index}})" class="btn btn-info btn-xs" title="详情">详</button>
													{@if data.status == '1'}
														<button onclick="changeStatus('{{data.id}}', '0')" class="btn btn-danger btn-xs" title="禁用">禁</button>
													{@else}
														<button onclick="changeStatus('{{data.id}}', '1')" class="btn btn-danger btn-xs" title="启用">启</button>
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
	
	<div id="ccmtShade" class="ccmt-shade"></div>
	<!-- 详情界面 -->
	<div id="viewPanel" class="ccmt-shade-dialog">
		<div class="row">
			<div class="x_panel">
				<div class="x_title">
                   	<h2>用户详情<small></small></h2>
                	<div class="clearfix"></div>
           		</div>
           		
	           	<div class="x_content view-panel">
	           		<div class="vp-content">
		           		<div class="">
		                	<div class="vpcol3">
		                		<div class="vpcol-label">用户名：</div>
		                		<div name="username"></div>
		                    </div>
		                    <div class="vpcol3">
		                		<div class="vpcol-label">姓名：</div>
		                		<div name="name"></div>
		                    </div>
		                    <div class="vpcol3">
		                		<div class="vpcol-label">状态：</div>
		                		<div name="statusStr"></div>
		                    </div>
		                    <div class="vpcol3">
		                		<div class="vpcol-label">生日：</div>
		                		<div name="birthdayStr"></div>
		                    </div>
		                    <div class="vpcol3">
		                		<div class="vpcol-label">性别：</div>
		                		<div name="sexStr" id="vpSex"></div>
		                    </div>
		                    <div class="vpcol3">
		                		<div class="vpcol-label">创建时间：</div>
		                		<div name="createTimeStr"></div>
		                    </div>
						</div>
	           		</div>
	           		
	           		<div class="vp-btns">
						<div class="col-md-12 col-sm-12 col-xs-12 col-md-offset-4">
							<button onclick="closeView()" class="btn btn-primary ccmt-btn"> 关   闭 </button>
						</div>
					</div>
	           	</div>
           	</div>
		</div>
	</div>
	
	<script type="text/javascript" src="${ctx}/static/js/sms/user/userList.js"></script>
</body>
</html>