package com.huijiasoft.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jfinal.handler.Handler;
import com.jfinal.kit.HandlerKit;

/**
 * @author pangPython
 *
 */

public class ResourceHandler extends Handler {

	
	
	
	@Override
	public void handle(String target, HttpServletRequest request, HttpServletResponse response, boolean[] isHandled) {
		System.out.println("target: "+target);
		if(isDisableAccess(target)){
			HandlerKit.renderError404(request, response, isHandled);
		}
		next.handle(target, request, response, isHandled);
	}
	
	

	private static boolean isDisableAccess(String target) {
		String suffixHtml = ".html";
		String suffixFTL  = ".ftl";
		// 防止直接访问模板文件
		if (target.endsWith(suffixHtml) || target.endsWith(suffixFTL)) {
			return true;
		}

		return false;
}
	

}
