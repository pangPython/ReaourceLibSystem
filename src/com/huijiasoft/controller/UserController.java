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
			
			if(user.getAge()==null){
				render("/adduserinfo.html");
				
			}else{
				
				render("/user.html");
			}
			
			
		
		
	}
	
	//用户中心方法
	public void center() {
User user = (User) getSession().getAttribute(getCookie("cuser"));
		
		setAttr("user", user);
		render("/center.html");
	}
	//已经登录用户的退出操作
	public void logout(){
		removeSessionAttr(getCookie("cuser"));
		removeCookie("cuser");
		redirect("/");
	}
	
	//个人音频视频资料
	public void mediainfo(){
		render("/mediainfo.html");
	}
	
	
	public void edit(){
		User user = (User) getSession().getAttribute(getCookie("cuser"));
		
		setAttr("user", user);
		render("/editinfo.html");
	}

}
