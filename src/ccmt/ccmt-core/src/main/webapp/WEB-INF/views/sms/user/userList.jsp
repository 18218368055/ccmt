<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>

<style>
#test {
    width:100%;
    height:100%;
    background-color:#000;
    position:absolute;
    top:0;
    left:0;
    z-index:2;
    opacity:0.3;
    /*兼容IE8及以下版本浏览器*/
    filter: alpha(opacity=30);
    display:none;
}

#log_window {
    width:200px;
    height:200px;
    background-color:#FF0;    
    margin: auto;
    position: absolute;
    z-index:3;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    display:none;
}
</style>
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
										{@each dataList as user}
											<tr>
												<td>{{user.id}}</td>
												<td>{{user.username}}</td>
												<td>{{user.name}}</td>
												<td>{{user.sex}}</td>
												<td>{{user.birthday}}</td>
												<td>{{user.status}}</td>
												<td>
													<button class="btn btn-info btn-xs" title="详情">详</button>
													{@if user.status == '1'}
														<button onclick="changeStatus('{{user.id}}', '0')" class="btn btn-danger btn-xs" title="禁用">禁</button>
													{@else}
														<button onclick="changeStatus('{{user.id}}', '1')" class="btn btn-danger btn-xs" title="启用">启</button>
													{@/if}
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
	
	<a href="javascript:shield()">打开遮罩</a>
	<div id="test"></div>
	<div id="log_window">
		<a href="javascript:cancel_shield()">关闭</a>
	</div>
	
	<div id="ccmt-shade" class="ccmtShade"></div>
	<div id="" class="ccmtShadeWindow">
		
	</div>
	
	<script type="text/javascript" src="${ctx}/static/js/sms/user/userList.js"></script>
	<script>
function shield(){
    var s = document.getElementById("test");
    s.style.display = "block";
    
    var l = document.getElementById("log_window");
    l.style.display = "block";
}

function cancel_shield(){
    var s = document.getElementById("test");
    s.style.display = "none";
    
    var l = document.getElementById("log_window");
    l.style.display = "none";
}
</script>
</body>
</html>