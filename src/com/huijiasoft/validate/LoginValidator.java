package com.huijiasoft.validate;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;;

public class LoginValidator extends Validator {

	@Override
	protected void handleError(Controller arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void validate(Controller ctlr) {
		validateRequiredString("login.name", "errMsg", "请输入用户名！");
		
	}

}
