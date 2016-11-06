package com.huijiasoft.interceptor;

import com.huijiasoft.model.Admin;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

/**
 * @author pangPython
 *	超级管理员权限检测
 */
public class SuAuthInterceptor implements Interceptor {

	public void intercept(Invocation inv) {
		Controller controller = inv.getController();
		Admin admin = controller.getSessionAttr(controller.getCookie("cadmin"));
		
		if(admin.getType()!=0){
			controller.redirect("/admin/xqadmin");
		}else{
			inv.invoke();
		}
	}

}
