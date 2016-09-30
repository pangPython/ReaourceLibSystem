package com.huijiasoft.routes;

import com.huijiasoft.controller.AdminController;
import com.jfinal.config.Routes;



/**
 * @author pangPython
 *
 */
public class AdminRoutes extends Routes {

	@Override
	public void config() {
		add("/admin",AdminController.class);
	}

}
