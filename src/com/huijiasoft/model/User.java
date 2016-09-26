package com.huijiasoft.model;

import com.huijiasoft.model.base.BaseUser;
import com.jfinal.plugin.activerecord.Page;

@SuppressWarnings("serial")
public class User extends BaseUser<User> {
	
	public static final User usermodel = new User();
	
	public Page<User> paginate(int pageNumber,int pageSize){
		
		return paginate(pageNumber, pageSize, "select *", "from user");
	}
	

}
