<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>数据字典类型新增</title>
	
	<link href="${ctx}/static/plugins/gentelella/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
	<link href="${ctx}/static/css/pagination.css" rel="stylesheet">
</head>
<body>	
	<div class="">
        <div class="row">
	    	<div class="col-md-12 col-sm-12 col-xs-12">
            	<div class="x_panel">
            		<div class="x_title">
                    	<h2>新增数据字典类型<small></small></h2>
                   		<div class="clearfix"></div>
                  	</div>
                  	
                  	<div class="x_content efc-content">
						<form id="addForm" class="form-horizontal form-label-left">
							<div class="item form-group efc-row">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">
									类型代码<span class="red">*</span>：
								</label>
		                        <div class="col-md-5 col-sm-6 col-xs-12">
		                        	<input name="typeCode" class="required form-control col-md-7 col-xs-12" type="text">
		                        </div>
								<div class="alert"></div>
							</div>
							<div class="item form-group efc-row">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">
									类型名称<span class="red">*</span>：
								</label>
		                        <div class="col-md-5 col-sm-6 col-xs-12">
		                        	<input name="typeName" class="required form-control col-md-7 col-xs-12" type="text">
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
	                        	<button onclick="toList()" type="button" class="btn btn-primary ccmt-btn">取消</button>
	                        	<button type="submit" class="btn btn-primary ccmt-btn">提交</button>
	                        </div>
	                      </div>
						</form>                  		
                  	</div>
            	</div>
           	</div>
        </div>
	</div>
	
	<script type="text/javascript" src="${ctx}/static/js/plugins/jquery.validate.js"></script>
	<script type="text/javascript" src="${ctx}/static/js/sm/sbd/dict/dictTypeAdd.js"></script>
</body>
</html>







