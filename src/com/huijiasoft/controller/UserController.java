package com.huijiasoft.controller;

import com.jfinal.core.Controller;

/**
 * @author pangPython
 *
 */

public class UserController extends Controller {
	
	public void index() {
		renderText("用户！");
	}
	
	//用户中心方法
	public void center() {
		renderText("用户中心！");
	}
	
	
	

}
