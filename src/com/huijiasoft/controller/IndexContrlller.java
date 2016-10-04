package com.huijiasoft.controller;

import com.huijiasoft.model.User;
import com.huijiasoft.service.IndexService;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.ext.kit.SessionIdKit;

/**
 * @author pangPython
 *	前端控制器
 */

public class IndexContrlller extends Controller {
	
	//进入首页
	
	@ActionKey("/")
	public void index(){
			setAttr("system", IndexService.getSysConfig());
			render("index.html");	
	}
	
	
	//前台登录方法
	
	public void login(){
		//如果请求参数cookie中可以获取到当前登录用户
		//先移除其登录信息
		String cuser = getCookie("cuser");
		System.out.println(cuser+"=========cuser");
		if(cuser!=null){
			removeSessionAttr(cuser);
		}
		
		String uname = getPara("uname");
		String pwd = getPara("password");
		
		String sql = "select * from user where uname = ? and pwd = ? limit 1";
		
		User user = User.usermodel.findFirst(sql,uname,pwd);
		//登录成功
		if(user!=null){
			//生成唯一标识
			String sessionId = SessionIdKit.me().generate(getRequest());
			//设置服务器端session
			setSessionAttr(sessionId, user);
			//设置用户端cookie
			setCookie("cuser", sessionId, 600);
			redirect("/user");
		}else{
			setAttr("system", IndexService.getSysConfig());
			render("login.html");
		}
		
	}
	
	//注册
	
	public void regist(){
		render("regist.html");
	}
	
	
	
}
