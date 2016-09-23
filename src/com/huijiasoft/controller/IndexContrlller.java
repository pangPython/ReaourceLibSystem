package com.huijiasoft.controller;

import com.huijiasoft.validate.LoginValidator;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

public class IndexContrlller extends Controller {
	//进入首页
	
	public void index(){
		if(getSessionAttr("uanme")){
			setAttr("errMsg", "hahahah");
		}
		render("index.html");
	}
	
	@Before(LoginValidator.class)
	public void login(){
		//登录之前先进行判断session是否有用户登录
		//y logined
		//n login register
		
		System.out.println(getPara("login.name"));
		if ("admin"==getPara("login.name")) {
			setSessionAttr("uname", "login");
		}
		render("index.html");
	}
	
	
	
	
}
