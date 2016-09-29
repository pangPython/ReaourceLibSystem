package com.huijiasoft.model;



import java.util.List;

import com.huijiasoft.model.base.BaseUser;
import com.jfinal.plugin.activerecord.Page;

@SuppressWarnings("serial")
public class User extends BaseUser<User> {
	
	public static final User usermodel = new User();
	
	
	//Jfinal提供分页
	public Page<User> paginate(int pageNumber,int pageSize){
		
		return paginate(pageNumber, pageSize, "select *", "from user order by id asc");
	}
	
	//未使用Jfinal分页，使用h-ui-admin提供的js分页
	public List<User> getAllUser(){
		return  usermodel.find("select * from user order by id asc");
	}

	
	

}
