package com.huijiasoft.routes;

import com.huijiasoft.controller.CommonController;
import com.huijiasoft.controller.IndexContrlller;
import com.huijiasoft.controller.UserController;
import com.jfinal.config.Routes;

/**
 * @author pangPython
 *
 */
public class FrontRoutes extends Routes {

	@Override
	public void config() {
		add("/",IndexContrlller.class);
		add("/common",CommonController.class);
		add("/user",UserController.class);
	}

}
