package com.huijiasoft.config;

import com.huijiasoft.controller.AdminController;
import com.huijiasoft.controller.IndexContrlller;
import com.huijiasoft.controller.UserController;
import com.huijiasoft.handler.ResourceHandler;
import com.huijiasoft.model.User;
import com.huijiasoft.model._MappingKit;
import com.huijiasoft.routes.AdminRoutes;
import com.huijiasoft.routes.FrontRoutes;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.ext.handler.UrlSkipHandler;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;

public class MyJFinalConfig extends JFinalConfig {

	public static void main(String[] args) {
		JFinal.start("WebRoot",80,"/",5);
	}
	
	
	@Override
	public void configConstant(Constants me) {
		PropKit.use("myconfig.txt");
		me.setDevMode(PropKit.getBoolean("devMode", false));
		me.setError404View("admin/404.html");
		me.setBaseDownloadPath("WebRoot/");

	}
	
	
	@Override
	public void configRoute(Routes me) {
		//配置前端路由
		me.add(new FrontRoutes());
		//配置后端路由
		me.add(new AdminRoutes());
	}

	@Override
	public void configHandler(Handlers me) {
		//跳过html等请求
		//new UrlSkipHandler(".+\\.\\w{1,4}", false)
		me.add(new ResourceHandler());
	}

	@Override
	public void configInterceptor(Interceptors arg0) {
		// TODO Auto-generated method stub

	}
	
	public static C3p0Plugin createC3p0Plugin(){
		return new C3p0Plugin(PropKit.get("jdbcUrl"),PropKit.get("user"),PropKit.get("password").trim());
	}
	

	@Override
	public void configPlugin(Plugins me) {
		C3p0Plugin c3p0Plugin = createC3p0Plugin();
		me.add(c3p0Plugin);
		
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		
		me.add(arp);
		
		_MappingKit.mapping(arp);
		

	}
	


}
