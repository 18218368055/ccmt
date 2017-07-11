package com.qylyx.ccmt.config;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.qylyx.ccmt.sms.entity.user.vo.SmsUserVO;
import com.qylyx.ccmt.sms.service.pms.ISmsPermissionService;
import com.qylyx.ccmt.sms.service.user.ISmsUserService;
import com.qylyx.remex.base.entity.Result;
import com.qylyx.remex.base.rconst.result.RemexResultConst;

/**
 * 登录权限登录器
 * 
 * @author Qiaoxin.Hong
 *
 */
public class ShiroRealm extends AuthorizingRealm {
	private final static Logger logger = LoggerFactory.getLogger(ShiroRealm.class);
	
	@Autowired
	ISmsUserService smsUserService;
	
	@Autowired
	ISmsPermissionService smsPermissionService;

	/**
	 * 认证.登录
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		Result<SmsUserVO> result = smsUserService.login(upToken.getUsername());
		if (result.isFailed())
			throw new AuthenticationException("登录失败，" + result.getLog());
		SmsUserVO user = result.getData();
		if (user == null)
			throw new AuthenticationException("登录失败，未查询到用户，用户名：" + upToken.getUsername());
		return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
	}
	
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		SmsUserVO user = (SmsUserVO) getAvailablePrincipal(principals);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		
		Set<String> permissionList = null;
		//查询用户权限列表
		Result<Set<String>> result = smsPermissionService.querySysUsePermissionList(user.getId());
		if (RemexResultConst.CODE_SUCCESS.equals(result.getCode())) {
			permissionList = result.getData();
		} else {
			logger.error("用户（" + user.getId() + "）获取权限列表异常，" + result.getLog());
			permissionList = new HashSet<String>();
		}
		info.addStringPermissions(permissionList);
		return info;
	}
}
