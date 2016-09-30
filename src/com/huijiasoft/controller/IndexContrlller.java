package com.huijiasoft.controller;

import com.huijiasoft.service.IndexService;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

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
		setAttr("system", IndexService.getSysConfig());
		render("login.html");
	}
	
	//注册
	public void regist(){
		render("regist.html");
	}
	
	
	
}
