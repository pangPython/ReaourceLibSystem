package com.huijiasoft.validate;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class AdminValidator extends Validator{

	@Override
	protected void handleError(Controller arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void validate(Controller arg0) {
		validateRequiredString("admin.name", "LoginMsg","请输入用户名！");
		
	}

}
