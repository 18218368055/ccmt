<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                    	<ul class="nav navbar-right panel_toolbox">
                      		<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                      		<li class="dropdown">
                        		<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        		<ul class="dropdown-menu" role="menu">
	                          		<li><a href="#">Settings 1</a></li>
	                          		<li><a href="#">Settings 2</a></li>
                        		</ul>
                      		</li>
                      		<li><a class="close-link"><i class="fa fa-close"></i></a></li>
                    	</ul>
                   		<div class="clearfix"></div>
                  	</div>
                  	
                  	<div class="x_content">
							<div class="row csb-row">
								<form id="queryForm">
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
										<select name="status" class="form-control csb-control">
											<option value="">全部</option>
											<option value="1">启用</option>
											<option value="0">禁用</option>
										</select>
									</div>
									<%-- <div class="col-md-3 col-sm-12 col-xs-12 form-group">
										<span class="csb-label">性别：</span>
										<jd:group var="sexList" code="SEX"/>
										<select name="sex" class="form-control csb-control">
											<option value="">全部</option>
											<c:forEach var="sex" items="${sexList}">
												<option value="${sex.code}">${sex.name}</option>
											</c:forEach>
										</select>
									</div> --%>
								</form>
							</div>
							
							<div class="row csb-row">
								<div class="col-md-12 col-sm-12 col-xs-12 col-md-offset-4">
									<button onclick="initSearch()" class="btn btn-success ccmt-btn"> 查   询 </button>
								</div>
							</div>
							
							<div class="row dtb-row">
								<table id="dataTable"></table>
								<div id="dataPage"></div>
							</div>
                  	</div>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript" src="${ctx}/static/js/sms/user/userList.js"></script>
</body>
</html>