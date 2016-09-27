package com.huijiasoft.controller;

import com.huijiasoft.model.DeclareType;
import com.huijiasoft.model.Mz;
import com.huijiasoft.model.User;
import com.huijiasoft.model.Zzmm;
import com.huijiasoft.validate.AdminValidator;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.render.CaptchaRender;

public class AdminController extends Controller {
	
	public void index(){
		render("index.html");
	}
	
	@Before(AdminValidator.class)
	public void login(){
		
		String admin_name = getPara("admin.name");
		String admin_pwd = getPara("admin.pwd");
		
		System.out.println(admin_name+"-------------");
		
		if("admin".equals(admin_name)&&"admin".equals(admin_pwd)){
			render("index.html");
		}
		
	}
	
	
	public void img(){
		render(new CaptchaRender());
	}
	
	
	//后台搜索页面
	public void search(){
		setAttr("userPage", User.usermodel.paginate(getParaToInt(0,1), 10));
		render("article-list.html");
	}
	
	//申报类型管理
	public void declare(){
		setAttr("declarePage",DeclareType.dao.paginate(getParaToInt(0,1), 10));
		render("declare.html");
	}
	
	//民族分类管理
	
	public void nation(){
		setAttr("nationPage", Mz.dao.paginate(getParaToInt(0,1), 10));
		render("nation.html");
	}
	
	
	//政治面貌管理
	public void zzmm(){
		setAttr("zzmmPage", Zzmm.dao.paginate(getParaToInt(0,1), 10));
		render("zzmm.html");
	}
	
}
