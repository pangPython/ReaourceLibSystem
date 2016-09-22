package com.huijiasoft.demo;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;

public class DemoConfig extends JFinalConfig{

	@Override
	public void configConstant(Constants me) {
		me.setDevMode(true);
		
	}


	@Override
	public void configRoute(Routes me) {
		me.add("/hello",HelloContrlller.class);
		me.add("/admin",AdminController.class);
		
	}


	@Override
	public void configHandler(Handlers arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void configInterceptor(Interceptors arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void configPlugin(Plugins arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
