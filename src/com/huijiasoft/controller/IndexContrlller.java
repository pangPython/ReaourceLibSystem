package com.huijiasoft.controller;

import com.huijiasoft.service.IndexService;
import com.jfinal.core.Controller;

/**
 * @author pangPython
 *
 */
public class IndexContrlller extends Controller {
	//进入首页
	
	public void index(){
		//if(IndexService.siteIsOpen()){
			setAttr("system", IndexService.getSysConfig());
			render("index.html");	
	//	}else{
	//		renderText("站点已经关闭！");
	//	}
		
	}
	
	
	public void login(){
		setAttr("system", IndexService.getSysConfig());
		render("login.html");
	}
	
	public void regist(){
		render("regist.html");
	}
	
	
}
