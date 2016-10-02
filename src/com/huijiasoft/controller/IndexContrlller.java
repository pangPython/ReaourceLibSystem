package com.huijiasoft.controller;

import com.huijiasoft.interceptor.UserAuthInterceptor;
import com.huijiasoft.model.User;
import com.huijiasoft.service.IndexService;
import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

/**
 * @author pangPython
 *	前端控制器
 */
@Before(UserAuthInterceptor.class)
public class IndexContrlller extends Controller {
	
	//进入首页
	@ActionKey("/")
	public void index(){
			setAttr("system", IndexService.getSysConfig());
			render("index.html");	
	}
	
	
	//前台登录方法
	@Clear
	public void login(){
		String uname = getPara("uname");
		String pwd = getPara("password");
		
		String sql = "select * from user where uname = ? and pwd = ? limit 1";
		
		User user = User.usermodel.findFirst(sql,uname,pwd);
		//登录成功
		if(user!=null){
			setSessionAttr(user.getId().toString(), user);
			redirect("/user");
		}else{
			setAttr("system", IndexService.getSysConfig());
			render("login.html");
		}
		
	}
	
	//注册
	@Clear
	public void regist(){
		render("regist.html");
	}
	
	
	
}
