package com.huijiasoft.validate;

import com.huijiasoft.model.User;
import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;;


/**
 * @author pangPython
 *
 */
public class LoginValidator extends Validator {

	@Override
	protected void handleError(Controller controller) {
		controller.keepModel(User.class);
	}

	@Override
	protected void validate(Controller ctlr) {
		validateRequiredString("login.name", "UnameErrMsg", "请输入用户名！");
		validateRequiredString("login.password", "PwdErrMsg", "请输入密码！");
		validateRequiredString("login.verifycode", "yzmErrMsg", "请输入验证码！");
		
	}

}
