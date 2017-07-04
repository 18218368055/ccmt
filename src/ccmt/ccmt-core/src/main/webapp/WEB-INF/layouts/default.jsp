<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>
		<sitemesh:write property="title"/>
	</title>

	<!-- Bootstrap -->
	<link href="${ctx}/static/plugins/gentelella/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
	<!-- Font Awesome -->
	<link href="${ctx}/static/plugins/gentelella/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
	<!-- NProgress -->
	<link href="${ctx}/static/plugins/gentelella/vendors/nprogress/nprogress.css" rel="stylesheet">
	<!-- Custom Theme Style -->
    <link href="${ctx}/static/plugins/gentelella/build/css/custom.css" rel="stylesheet">
    <!-- jqGrid样式 -->
    <link rel="stylesheet" href="${ctx}/static/plugins/jqgrid/css/ui.jqgrid.css">
    <!-- jQuery ui样式 -->
	<link rel="stylesheet" href="${ctx}/static/plugins/jqgrid/css/ui/redmond/jquery-ui-1.8.16.custom.css">
    <%-- <link href="${ctx}/static/css/my-custom.css" rel="stylesheet"> --%>
	<!-- jquery -->
	<script type="text/javascript" src="${ctx}/static/js/plugins/jquery-1.9.1.js"></script>
	<!-- jqGrid -->
	<script type="text/javascript" src="${ctx}/static/plugins/jqgrid/js/jquery.jqGrid.js"></script>
	<!-- jqGrid中文语言包 -->
	<script type="text/javascript" src="${ctx}/static/plugins/jqgrid/js/i18n/grid.locale-cn.js"></script>
	<!-- july工具函数库 -->
	<script type="text/javascript" src="${ctx}/static/js/plugins/july.js"></script>
	<!-- remex标准函数库 -->
	<script type="text/javascript" src="${ctx}/static/js/plugins/remex.js"></script>
	<!-- CCMT通用函数 -->
	<script type="text/javascript" src="${ctx}/static/js/common/common.js"></script>
	<!-- js插件库的初始化及相关通用操作 -->
	<%-- <script type="text/javascript" src="${ctx}/static/js/common/plugins.js"></script> --%>

	<sitemesh:write property="head"/>
</head>

<body class="nav-md">
	<input type="hidden" id="ctx" value="${ctx}"/>
	<sitemesh:write property='body' />
</body>
</html>