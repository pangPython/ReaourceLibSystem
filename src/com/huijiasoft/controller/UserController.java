package com.huijiasoft.controller;

import com.huijiasoft.validate.LoginValidator;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

/**
 * @author pangPython
 *
 */
public class UserController extends Controller {
	
	@Before(LoginValidator.class)
	public void login(){
		
		render("blog.html");
	}
	

}
