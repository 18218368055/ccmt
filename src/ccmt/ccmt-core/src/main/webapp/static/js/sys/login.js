// *** 登录、注册 ***

$(document).ready(function(){
	
});

/**
 * 登录
 */
function login () {
	if ($("#loginName").val() == "") {
		fmsg("用户名不能为空！");
		return false;
	}
	if ($("#loginPwd").val() == "") {
		fmsg("密码不能为空！");
		return false;
	}
	july.formBuildSubmit(getCtx() + "/login", {
		username : $("#loginName").val(),
		password : $("#loginPwd").val(),
	});
}