package com.huijiasoft.utils;

import com.jfinal.core.Controller;

/**
 * @author pangPython
 *	控制器工具类
 */
public class ControllerUtils {
		//通过客户端请求的返回session中存储的model
		public static Object getMFromSbyIdinC(Controller controller,String cookieStr){
			 return controller.getSessionAttr(controller.getCookie(cookieStr));
		}
}
