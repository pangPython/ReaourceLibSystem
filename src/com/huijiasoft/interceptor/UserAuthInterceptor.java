package com.huijiasoft.interceptor;

import com.huijiasoft.model.User;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

/**
 * @author pangPython
 *	用户操作的权限拦截器
 */
public class UserAuthInterceptor implements Interceptor {

	public void intercept(Invocation inv) {
		
			Controller controller = inv.getController();
			//通过客户端请求中的cookie的key获取cookie的value
			String cuser = controller.getCookie("cuser");
			//在服务器端session中查找是否存在当前用户
			User user = controller.getSessionAttr(cuser);
			if(user == null || inv.getMethodName().equals("login")){
				controller.redirect("/loginpage");
			}else{
				inv.invoke();
			}
			
	}

}
