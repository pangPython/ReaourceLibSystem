package com.huijiasoft.validate;

import com.huijiasoft.model.User;
import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;




/**
 * @author pangPython
 *		更新用户信息验证器
 */
public class UserUpdateValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		validateRequired("user.true_name", "nameErrMsg", "用户名不能为空！");
		validateRequired("user.birth", "birthErrMsg", "出生年月不能为空！");
		validateRequired("user.join_work", "jwErrMsg", "上班时间不能为空！");
		validateRequired("user.card", "cardErrMsg", "身份证号不能为空！");
		validateRequired("user.health", "hErrMsg", "健康状况不能为空！");
		validateRequired("user.company", "comErrMsg", "公司信息不能为空！");
		validateRequired("user.company_tel", "comtelErrMsg", "单位电话不能为空！");
		validateRequired("user.address", "addrErrMsg", "地址不能为空");
		validateRequired("user.telephone", "telErrMsg", "移动电话不能为空！");
		validateRequired("user.ysjj","ysjjErrMsg","艺术简介不能为空!");
		validateRequired("user.business_achievement","baErrMsg","业务成就不能为空！");
		validateRequired("user.awards","awsErrMsg","获奖情况不能为空！");
		validateRequired("user.opinion","opErrMsg","本人申请意见不能为空！");
	}

	@Override
	protected void handleError(Controller c) {
		c.keepModel(User.class);
		//c.renderText("请重新填写所有字段！");
	}

}
