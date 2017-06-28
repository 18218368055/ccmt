<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>CCMT登录</title>
    <!-- Animate.css -->
    <link href="${ctx}/static/plugins/gentelella/vendors/animate.css/animate.min.css" rel="stylesheet">
</head>
<body class="login">
    <div>
      <a class="hiddenanchor" id="signup"></a>
      <a class="hiddenanchor" id="signin"></a>

      <div class="login_wrapper">
        <div class="animate form login_form">
          <section class="login_content">
            <form id="loginForm">
              <h1>登    录</h1>
              <div>
                <input id="loginName" value="admin" type="text" class="form-control" placeholder="用户名" required="" />
              </div>
              <div>
                <input id="loginPwd" value="888888" type="password" class="form-control" placeholder="密码" required="" />
              </div>
              <div>${errorMsg}</div>
              <div>
                <a class="btn btn-default submit" href="javascript:login();">登    录</a>
                <a class="reset_pass" href="#">忘记密码?</a>
              </div>

              <div class="clearfix"></div>

              <div class="separator">
                <p class="change_link">没有账号?
                  <a href="#signup" class="to_register">注 册 账 号！</a>
                </p>

                <div class="clearfix"></div>
                <br />

                <div>
                  <h1><i class="fa fa-paw"></i> Gentelella Alela!</h1>
                  <p>©2016 All Rights Reserved. Gentelella Alela! is a Bootstrap 3 template. Privacy and Terms</p>
                </div>
              </div>
            </form>
          </section>
        </div>

        <div id="register" class="animate form registration_form">
          <section class="login_content">
            <form>
              <h1>注 册 账 号</h1>
              <div>
                <input type="text" class="form-control" placeholder="用户名" required="" />
              </div>
              <div>
                <input type="password" class="form-control" placeholder="密码" required="" />
              </div>
              <div>
                <a class="btn btn-default submit" href="index.html">注  册</a>
              </div>

              <div class="clearfix"></div>

              <div class="separator">
                <p class="change_link">已有账号 ?
                  <a href="#signin" class="to_register"> 登 录 </a>
                </p>

                <div class="clearfix"></div>
                <br />

                <div>
                  <h1><i class="fa fa-paw"></i> Gentelella Alela!</h1>
                  <p>©2016 All Rights Reserved. Gentelella Alela! is a Bootstrap 3 template. Privacy and Terms</p>
                </div>
              </div>
            </form>
          </section>
        </div>
      </div>
    </div>
    
    
    <%-- <script type="text/javascript" src="${ctx}/static/js/sys/login.js"></script> --%>
  </body>
</html>







