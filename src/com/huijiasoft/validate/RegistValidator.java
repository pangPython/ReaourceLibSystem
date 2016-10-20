package com.huijiasoft.validate;

import com.huijiasoft.model.User;
import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;


/**
 * @author pangPython
 *  用户注册验证器 
 */
public class RegistValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		//是否为空验证
		validateRequired("user.uname", "unameMsg", "请输入用户名!");
		validateRequired("user.pwd", "pwdMsg", "请输入密码!");
		validateRequired("reg.confirmpwd", "confirmMsg", "请再输入一遍密码!");
		validateRequired("reg.verifycode", "vcMsg", "请输入验证码!");
	}

	@Override
	protected void handleError(Controller c) {
			c.keepModel(User.class);
	}

}
