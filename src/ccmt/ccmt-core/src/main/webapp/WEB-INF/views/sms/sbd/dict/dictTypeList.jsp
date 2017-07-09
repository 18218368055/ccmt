<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据字典类型列表</title>
</head>
<body>
	<div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
                    	<h2>数据字典类型列表<small></small></h2>
                    	<div class="clearfix"></div>
                  	</div>
                  	
                  	<div class="x_content">
						<div class="row csb-row">
							<form id="searchForm">
								
							</form>
						</div>
						
						<div class="row csb-row">
							<div class="col-md-12 col-sm-12 col-xs-12 col-md-offset-4">
								<button onclick="search()" class="btn btn-success ccmt-btn"> 查   询 </button>
								<button onclick="openAdd()" class="btn btn-primary ccmt-btn"> 新   增 </button>
							</div>
						</div>
						<div class="row dtb-row">
							<table class="table table-bordered">
								<thead>
                          			<tr class="">
                          				<th>ID</th>
                          				<th>字典类型代码</th>
                          				<th>字典类型名称</th>
                          				<th>备注</th>
                          				<th>状态</th>
                          				<th>操作</th>
                          			</tr>
                        		</thead>
                        		<tbody id="tableDataList">
                        			<script type="text/template" id="tempDataList">
                        				{@each dataList as data, index}
                        					<tr>
	                        					<td>{{data.id}}</td>
	                        					<td>{{data.typeCode}}</td>
	                        					<td>{{data.typeName}}</td>
	                        					<td>{{data.remark}}</td>
	                        					<td>{@out ccmtDd.tran(data.status, 'SMS_DICT_TYPE_STATUS')}</td>
	                        					<td>
	                        						<button onclick="openDict('{{index}}')" class="btn btn-info btn-xs" title="数据字典">典</button>
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
	
	<!-- 遮罩层 -->
	<div id="ccmtShade" class="ccmt-shade"></div>
	<div id="ccmtShadeTwo" class="ccmt-shade-two"></div>
	
	<!-- 新增界面 -->
	<div id="addPanel" class="ccmt-shade-dialog">
		<div class="row">
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
	                        	<input value="启用" readonly="readonly" class="form-control col-md-7 col-xs-12" type="text">
	                        	<input name="status" value="1" type="hidden"/>
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
	
	<!-- 数据字典界面 -->
	<div id="dictPanel" class="ccmt-shade-dialog">
		<div class="row">
			<div class="x_panel">
				<div class="x_title">
                   	<h2>数据字典列表（<em id="dictPanelTitle"></em>）<small></small></h2>
                	<div class="clearfix"></div>
           		</div>
           		
	           	<div class="x_content efc-content">
	           		<table class="table table-bordered">
						<thead>
                        	<tr class="">
	                          	<th>字典代码</th>
	                          	<th>字典名称</th>
	                          	<th>排序</th>
	                          	<th>备注</th>
	                          	<th>状态</th>
	                          	<th>操作</th>
                          	</tr>
                        </thead>
                        <tbody id="dictTableDataList">
                        	<script type="text/template" id="tempDictList">
                        		<tr>
                        			{@each dataList as data, index}
                       					<tr>
                        					<td>{{data.code}}</td>
                        					<td>{{data.name}}</td>
											<td>{{data.sort}}</td>
                        					<td>{{data.remark}}</td>
                        					<td>{@out ccmtDd.tran(data.status, 'SMS_DICT_STATUS')}</td>
                        					<td>
                        						<button onclick="" class="btn btn-info btn-xs" title="">详</button>
                        					</td>
                       					</tr>
                       				{@/each}
                        		</tr>
                        	</script>
						</tbody>
                	</table>
                	
                	<div class="form-group">
                    	<div class="col-md-6 col-md-offset-3">
                        	<button onclick="openAddDict()" class="btn btn-primary ccmt-btn" type="button"> 新   增 </button>
                        	<button onclick="closeListDict()" class="btn btn-primary ccmt-btn" type="button"> 关   闭 </button>
                        </div>
                	</div>   	
            	</div>
           	</div>
		</div>
	</div>
	
	<!-- 数据字典新增界面 -->
	<div id="addDictPanel" class="ccmt-shade-dialog-two">
		<div class="row">
			<div class="x_panel">
				<div class="x_title">
                   	<h2>新增数据字典<small></small></h2>
                	<div class="clearfix"></div>
           		</div>
           		
	           	<div class="x_content efc-content">
					<form id="addDictForm" class="form-horizontal form-label-left">
						<div class="item form-group efc-row">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">
								字典类型代码&nbsp;：
							</label>
	                        <div class="col-md-5 col-sm-6 col-xs-12">
	                        	<input id="addDictTypeCode" name="typeCode" value="" readonly="readonly" class="form-control col-md-7 col-xs-12" type="text">
	                        </div>
						</div>
						<div class="item form-group efc-row">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">
								字典类型名称&nbsp;：
							</label>
	                        <div class="col-md-5 col-sm-6 col-xs-12">
	                        	<input id="addDictTypeName" value="" readonly="readonly" class="form-control col-md-7 col-xs-12" type="text">
	                        </div>
						</div>
						<div class="item form-group efc-row">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">
								类型代码<span class="red">*</span>：
							</label>
	                        <div class="col-md-5 col-sm-6 col-xs-12">
	                        	<input name="code" class="required form-control col-md-7 col-xs-12" type="text">
	                        </div>
							<div class="alert"></div>
						</div>
						<div class="item form-group efc-row">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">
								类型名称<span class="red">*</span>：
							</label>
	                        <div class="col-md-5 col-sm-6 col-xs-12">
	                        	<input name="name" class="required form-control col-md-7 col-xs-12" type="text">
	                        </div>
							<div class="alert"></div>
						</div>
						<div class="item form-group efc-row">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">
								状态&nbsp;：
							</label>
	                        <div class="col-md-5 col-sm-6 col-xs-12">
	                        	<input value="启用" readonly="readonly" class="form-control col-md-7 col-xs-12" type="text">
	                        	<input name="status" value="1" type="hidden"/>
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
                        	<button onclick="addDict()" class="btn btn-primary ccmt-btn"> 提   交 </button>
                        	<button onclick="closeAddDict()" class="btn btn-primary ccmt-btn" type="button"> 取   消 </button>
                        </div>
                      </div>
					</form>                  		
            	</div>
           	</div>
		</div>
	</div>
	
	<script type="text/javascript" src="${ctx}/static/js/plugins/jquery.validate.js"></script>
	<script type="text/javascript" src="${ctx}/static/js/sms/sbd/dict/dictTypeList.js"></script>
</body>
</html>