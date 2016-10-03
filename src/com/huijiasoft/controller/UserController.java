package com.huijiasoft.controller;

import com.huijiasoft.interceptor.UserAuthInterceptor;
import com.huijiasoft.model.User;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

/**
 * @author pangPython
 *
 */
@Before(UserAuthInterceptor.class)
public class UserController extends Controller {
	
	public void index() {
		//使用客户端请求中的cookie中的user的唯一标识作为key
		//取服务器端的session
		User user = (User) getSession().getAttribute(getCookie("cuser"));
		
			setAttr("user", user);
			render("/user.html");
		
		
	}
	
	//用户中心方法
	public void center() {
		renderText("用户中心！");
	}
	//已经登录用户的退出操作
	public void logout(){
		removeAttr(getCookie("cuser"));
		removeCookie("cuser");
		render("/index.html");
	}
	
	

}
