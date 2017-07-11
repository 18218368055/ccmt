<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>CCMT首页</title>
	
    <!-- bootstrap-progressbar -->
    <link href="${ctx}/static/plugins/gentelella/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <!-- JQVMap -->
    <link href="${ctx}/static/plugins/gentelella/vendors/jqvmap/dist/jqvmap.min.css" rel="stylesheet"/>
    <!-- bootstrap-daterangepicker -->
    <link href="${ctx}/static/plugins/gentelella/vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
</head>
<body class="body-main">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">
					
					<div class="navbar nav_title" style="border: 0;">
		              <a href="${ctx}/main/index" class="site_title"><i class="fa fa-paw"></i> <span>Gentelella Alela!</span></a>
		            </div>
		            <div class="clearfix"></div>
		            
		            <div class="profile clearfix">
		            	<div class="profile_pic">
		                	<img src="${ctx}/static/images/picture.jpg" alt="..." class="img-circle profile_img">
		              	</div>
		              	<div class="profile_info">
		                	<span>欢迎您,</span>
		                	<h2><shiro:principal property="name"/></h2>
		            	</div>
		            </div>
		            
		            <br />
		            
		            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
		            	<div class="menu_section">
		            		<h3>General</h3>
		            		<ul class="nav side-menu">
		            			<li>
		            				<a><i class="fa fa-home"></i> 系统管理 <span class="fa fa-chevron-down"></span></a>
			                    	<ul class="nav child_menu">
			                    		<li><a onclick="turnMenu('${ctx}/sms/user/toList')" href="javascript:;">用户管理</a></li>
			                    		<li><a onclick="turnMenu('${ctx}/sms/sbd/dictType/toList')" href="javascript:;">数据字典</a></li>
			                    		<li><a onclick="turnMenu('${ctx}/sms/pms/role/toList')" href="javascript:;">角色管理</a></li>
				                      	<li><a onclick="turnMenu('${ctx}/sms/pms/permission/toList')" href="javascript:;">权限管理</a></li>
			                    	</ul>
			                  	</li>
		            		</ul>
		            	</div>
		            </div>
		            
		            <div class="sidebar-footer hidden-small">
              			<a data-toggle="tooltip" data-placement="top" title="Settings">
                			<span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
              			</a>
              			<a data-toggle="tooltip" data-placement="top" title="FullScreen">
                			<span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
              			</a>
              			<a data-toggle="tooltip" data-placement="top" title="Lock">
                			<span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
              			</a>
              			<a data-toggle="tooltip" data-placement="top" title="Logout" href="login.html">
                			<span class="glyphicon glyphicon-off" aria-hidden="true"></span>
              			</a>
            		</div>
		            
				</div>
			</div>
			
			<div class="top_nav">
				<div class="nav_menu">
					<nav>
						<div class="nav toggle">
                			<a id="menu_toggle"><i class="fa fa-bars"></i></a>
              			</div>
              			
              			<ul class="nav navbar-nav navbar-right">
              				<li class="">
              					<a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
		                    		<img src="${ctx}/static/images/picture.jpg" alt="">
		                    		<shiro:principal property="name"/>
		                    		<span class=" fa fa-angle-down"></span>
		                  		</a>
		                  		<ul class="dropdown-menu dropdown-usermenu pull-right">
		                  			<li><a href="javascript:;">设置</a></li>
		                  			<li><a href="javascript:;">帮助</a></li>
                    				<li><a href="javascript:;"><i class="fa fa-sign-out pull-right"></i>退出</a></li>
		                  		</ul>
              				</li>
              			</ul>
					</nav>
				</div>
			</div>
			 <!-- scrolling="no" -->
			<div class="right_col" role="main">
				<iframe id="indexFrame" src="${ctx}/sms/user/toList" frameborder="0" width="100%" height="100%">
				</iframe>
			</div>
		</div>
	</div>

    <!-- Bootstrap -->
    <script src="${ctx}/static/plugins/gentelella/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="${ctx}/static/plugins/gentelella/vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="${ctx}/static/plugins/gentelella/vendors/nprogress/nprogress.js"></script>
    <!-- Chart.js -->
    <script src="${ctx}/static/plugins/gentelella/vendors/Chart.js/dist/Chart.min.js"></script>
    <!-- gauge.js -->
    <script src="${ctx}/static/plugins/gentelella/vendors/gauge.js/dist/gauge.min.js"></script>
    <!-- bootstrap-progressbar -->
    <script src="${ctx}/static/plugins/gentelella/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
    <!-- iCheck -->
    <script src="${ctx}/static/plugins/gentelella/vendors/iCheck/icheck.min.js"></script>
    <!-- Skycons -->
    <script src="${ctx}/static/plugins/gentelella/vendors/skycons/skycons.js"></script>
    <!-- Flot -->
    <script src="${ctx}/static/plugins/gentelella/vendors/Flot/jquery.flot.js"></script>
    <script src="${ctx}/static/plugins/gentelella/vendors/Flot/jquery.flot.pie.js"></script>
    <script src="${ctx}/static/plugins/gentelella/vendors/Flot/jquery.flot.time.js"></script>
    <script src="${ctx}/static/plugins/gentelella/vendors/Flot/jquery.flot.stack.js"></script>
    <script src="${ctx}/static/plugins/gentelella/vendors/Flot/jquery.flot.resize.js"></script>
    <!-- Flot plugins -->
    <script src="${ctx}/static/plugins/gentelella/vendors/flot.orderbars/js/jquery.flot.orderBars.js"></script>
    <script src="${ctx}/static/plugins/gentelella/vendors/flot-spline/js/jquery.flot.spline.min.js"></script>
    <script src="${ctx}/static/plugins/gentelella/vendors/flot.curvedlines/curvedLines.js"></script>
    <!-- DateJS -->
    <script src="${ctx}/static/plugins/gentelella/vendors/DateJS/build/date.js"></script>
    <!-- JQVMap -->
    <script src="${ctx}/static/plugins/gentelella/vendors/jqvmap/dist/jquery.vmap.js"></script>
    <script src="${ctx}/static/plugins/gentelella/vendors/jqvmap/dist/maps/jquery.vmap.world.js"></script>
    <script src="${ctx}/static/plugins/gentelella/vendors/jqvmap/examples/js/jquery.vmap.sampledata.js"></script>
    <!-- bootstrap-daterangepicker -->
    <script src="${ctx}/static/plugins/gentelella/vendors/moment/min/moment.min.js"></script>
    <script src="${ctx}/static/plugins/gentelella/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>
    <!-- Custom Theme Scripts -->
	<script src="${ctx}/static/plugins/gentelella/build/js/custom.min.js"></script>
	
	<!-- 数据字典 -->
	<script type="text/javascript" src="${ctx}/static/js/common/ccmt-dd.js"></script>
	<script type="text/javascript" src="${ctx}/static/js/sys/index.js"></script>
	
	<script type="text/javascript">
		//初始化数据字典
		ccmtDdSource.init({
			source : ${ccmtDictSource}
		});
	</script>
</body>
</html>







