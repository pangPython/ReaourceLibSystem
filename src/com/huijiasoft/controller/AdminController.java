package com.huijiasoft.controller;

import com.huijiasoft.validate.AdminValidator;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

public class AdminController extends Controller {
	
	public void index(){
		render("index.html");
	}
	
	@Before(AdminValidator.class)
	public void login(){
		
		String admin_name = getPara("admin.name");
		String admin_pwd = getPara("admin.pwd");
		
		System.out.println(admin_name+"-------------");
		
	}
	
	
	public void img(){
		renderCaptcha();
	}
	
}
