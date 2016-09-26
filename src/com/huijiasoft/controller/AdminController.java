package com.huijiasoft.controller;

import com.huijiasoft.validate.AdminValidator;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.render.CaptchaRender;

public class AdminController extends Controller {
	
	public void index(){
		render("index.html");
	}
	
	@Before(AdminValidator.class)
	public void login(){
		
		String admin_name = getPara("admin.name");
		String admin_pwd = getPara("admin.pwd");
		
		System.out.println(admin_name+"-------------");
		
		if("admin".equals(admin_name)&&"admin".equals(admin_pwd)){
			render("index.html");
		}
		
	}
	
	
	public void img(){
		render(new CaptchaRender());
	}
	
	
	
	
}
