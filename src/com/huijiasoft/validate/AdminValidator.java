package com.huijiasoft.validate;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/**
 * @author pangPython
 *
 */
public class AdminValidator extends Validator{

	@Override
	protected void handleError(Controller arg0) {
		// 
		
	}

	@Override
	protected void validate(Controller arg0) {
		validateRequiredString("admin.name", "LoginNameMsg","请输入用户名！");
		validateRequiredString("admin.pwd", "LoginPwdMsg","请输入密码！");
		validateCaptcha("verifycode", "codeMsg", "请输入验证码！");
	}

}
