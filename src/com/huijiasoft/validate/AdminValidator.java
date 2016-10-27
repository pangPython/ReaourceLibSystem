package com.huijiasoft.validate;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/**
 * @author pangPython
 *
 */
public class AdminValidator extends Validator{

	@Override
	protected void handleError(Controller controller) {
		controller.redirect("/admin/index");
	}

	@Override
	protected void validate(Controller arg0) {
		validateRequiredString("admin.name", "LoginNameMsg","请输入用户名！");
		validateRequiredString("admin.pwd", "LoginPwdMsg","请输入密码！");
		validateRequiredString("verifycode", "codeMeg", "请输入验证码！");
		//validateCaptcha("verifycode", "codeMsg", "请正确输入验证码！");
	}

}
