package com.huijiasoft.controller;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import com.jfinal.render.CaptchaRender;

/**
 * @author pangPython
 * 提取一些前后端都用得到的公共方法
 */

public class CommonController extends Controller {
	public void index() {
		renderText("common index");
	}
	//验证码生成
	@ActionKey("/verifycode")
	public void verifycode(){
		render(new CaptchaRender());
	}

}
