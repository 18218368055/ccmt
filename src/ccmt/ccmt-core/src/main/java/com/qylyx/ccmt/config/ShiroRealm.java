package com.qylyx.ccmt.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.qylyx.ccmt.sms.entity.user.vo.SmsUserVO;
import com.qylyx.ccmt.sms.service.ISmsUserService;
import com.qylyx.remex.base.entity.Result;

/**
 * 登录权限登录器
 * 
 * @author Qiaoxin.Hong
 *
 */
public class ShiroRealm extends AuthorizingRealm {
	
	@Autowired
	private ISmsUserService smsUserService;

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
		return new SimpleAuthenticationInfo(result.getData(), result.getData().getPassword(), getName());
	}
	
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}
}
