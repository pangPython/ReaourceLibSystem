package com.huijiasoft.controller;

import com.huijiasoft.service.IndexService;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

/**
 * @author pangPython
 *
 */
public class IndexContrlller extends Controller {
	//½øÈëÊ×Ò³
	
	@ActionKey("/")
	public void index(){
			setAttr("system", IndexService.getSysConfig());
			render("index.html");	
	}
	
	
	public void login(){
		setAttr("system", IndexService.getSysConfig());
		render("login.html");
	}
	
	public void regist(){
		render("regist.html");
	}
	
	
}
