package com.huijiasoft.interceptor;

import com.huijiasoft.model.Admin;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

public class AdminAuthInterceptor implements Interceptor {

	public void intercept(Invocation inv) {
		Controller controller = inv.getController();
		
		Admin admin = controller.getSessionAttr("Admin");
		
		if (admin == null || inv.getMethodName().equals("login")) {
			controller.render("login.html");
		}else{
			inv.invoke();
		}

	}

}
