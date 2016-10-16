package com.huijiasoft.controller;

import java.io.File;
import java.io.IOException;

import com.huijiasoft.interceptor.AdminAuthInterceptor;
import com.huijiasoft.model.Admin;
import com.huijiasoft.model.Area;
import com.huijiasoft.model.DeclareType;
import com.huijiasoft.model.Degree;
import com.huijiasoft.model.Edu;
import com.huijiasoft.model.Log;
import com.huijiasoft.model.Mz;
import com.huijiasoft.model.System;
import com.huijiasoft.model.User;
import com.huijiasoft.model.Zzmm;
import com.huijiasoft.utils.DateUtils;
import com.huijiasoft.utils.JavaMysqlUtil;
import com.huijiasoft.utils.MD5;
import com.huijiasoft.utils.WriteToDocx;
import com.huijiasoft.validate.AdminValidator;
import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;


/**
 * @author pangPython
 *	后台控制器
 */
@Before(AdminAuthInterceptor.class)
public class AdminController extends Controller {
	
	public void index(){
		render("index.html");
	}
	
	@ActionKey("/admin/")
	public void root(){
		render("index.html");
	}
	
	//取消登录验证的后台登录方法
	@Clear
	@Before(AdminValidator.class)
	public void login(){
		
		String admin_name = getPara("admin.name");
		String sql = "select * from admin where name = ? limit 1";
		
		Admin admin = Admin.dao.findFirst(sql,admin_name);
		if(admin != null){
			String admin_pwd = MD5.GetMD5Code(getPara("admin.pwd")+admin.getCreateTime());
			
			if(admin.getStatus() == 0){
				//setAttr("LoginNameMsg", "该管理员账号已禁用！");
				setAttr("LoginNameMsg","用户名或密码错误！");
				render("login.html");
				return;
			}

			if(!admin.getPwd().equals(admin_pwd)){
				setAttr("LoginNameMsg","用户名或密码错误！");
				render("login.html");
				return;
			}
			
			
			this.setSessionAttr("Admin", admin);
			//登录之后先记录日志
			
			String ip = this.getRequest().getRemoteAddr();
			String uname = admin.getName();
			String date = DateUtils.getNowTime();
			
			Log log = getModel(Log.class);
			
			log.setIp(ip);
			log.setUname(uname);
			log.setDate(date);
			log.save();

			if(admin.getType() == 0){
				
				redirect("index");
				
			}else{
				redirect("xqadmin");
			}
			
			
		}else{
			
			render("login.html");
			
		}
		
	}
	
	
	//县区管理员主页
	public void xqadmin(){
		
		render("countryadmin.html");
	}
	
	
	//县区管理员搜索
	public void xqsearch(){
		Admin admin = getSessionAttr("Admin");
		setAttr("userList", User.usermodel.getUserByAreaId(admin.getAreaId()));
		render("xqsearch.html");
	}
	
	
	
	//退出方法
	public void logout(){
		removeSessionAttr("Admin");
		redirect("index");
	}
	
	//后台服务器信息总览页面
	public void welcome() {
		render("welcome.html");
	}
	
	//后台搜索页面
	public void search(){
		setAttr("userList", User.usermodel.getAllUser());
		render("article-list.html");
	}
	
	//申报类型列表页面
	public void declare(){
		setAttr("declareList",DeclareType.dao.getAllDecType());
		render("declare.html");
	}
	
	//申报类型编辑页面
	public void declareedit(){
		setAttr("declare", DeclareType.dao.findById(getPara("id")));
		render("decedit.html");
	}
	//申报类型保存
	public void decupdate(){
		DeclareType.dao.set("dec_id",getPara("dec_id")).set("decname", getPara("decname")).update();
		renderText("申报类型更新成功！");
	}
	
	//民族分类管理
	
	public void nation(){
		setAttr("nationList", Mz.dao.getAllMz());
		render("nation.html");
	}
	
	//民族编辑页面
	public void nationedit(){
		setAttr("nation", Mz.dao.findById(getPara("id")));
		render("mzedit.html");
	}
	
	//民族字段更新
	@SuppressWarnings("static-access")
	public void nationupdate(){
		getModel(Mz.class).dao.set("mz_id", getPara("mz_id")).set("mzname", getPara("mzname")).update();
		renderText("民族信息更新成功！");
	}
	
	
	//政治面貌管理
	public void zzmm(){
		setAttr("zzmmList", Zzmm.dao.getAllZzmm());
		render("zzmm.html");
	}
	
	//政治面貌编辑页面
	public void zzmmedit(){
		setAttr("zzmm", Zzmm.dao.findById(getPara("id")));
		render("zzmmedit.html");
	}
	//政治面貌更新方法
	public void zzmmupdate(){
		Zzmm.dao.set("zzmm_id", getPara("zzmm_id")).set("zzmmname", getPara("zzmmname")).update();
		renderText("政治面貌更新成功！");
	}
	
	
	//学历信息管理
	public void education(){
		
		setAttr("educationList", Edu.dao.getAllEdu());
		render("education.html");
		
	}
	//学历信息编辑
	public void eduedit(){
		setAttr("edu", Edu.dao.findById(getPara("id")));
		render("eduedit.html");
	}
	//学历信息更新
	public void eduupdate(){
		Edu.dao.set("edu_id", getPara("edu_id")).set("eduname", getPara("eduname")).update();
		renderText("学历信息更新成功！");
	}
	
	//学位信息管理
	public void degree(){
		setAttr("degreeList", Degree.dao.getAllDegree());
		render("degree.html");
	}
	
	//学位信息编辑页面
	public void degreeedit(){
		setAttr("degree", Degree.dao.findById(getPara("id")));
		render("degreeedit.html");
	}
	//学位信息更新
	public void degreeupdate(){
		Degree.dao.set("degree_id", getPara("degree_id")).set("degreename", getPara("degreename")).update();
		renderText("学位信息更新成功！");
	}
	
	//地区管理
	public void area(){
		setAttr("areaList", Area.dao.getAllArea());
		render("area.html");
	}
	
	//地区信息编辑页面
	public void areaedit(){
		setAttr("area", Area.dao.findById(getPara("id")));
		render("areaedit.html");
		
	}
	//地区信息更新
	public void areaupdate(){
		Area.dao.set("area_id", getPara("area_id")).set("area_name", getPara("areaname")).update();
		renderText("地区信息更新成功！");
	}
	
	
	//系统参数配置
	public void system(){
		setAttr("system", System.dao.getSytem());
		render("system-base.html");
	}
	
	

	//系统参数更新
	public void systemINIupdate(){
		getModel(System.class).update();
		renderText("更新成功！");
	}
	
	//查看某个用户
	public void checkUser(){
		int uid = getParaToInt("id");
		User user = User.usermodel.findById_Relation(uid);
		String mzname = user.getStr("mzname");
		setAttr("user", user);
		setAttr("mz", mzname);
		setAttr("zzmm", user.getStr("zzmmname"));
		render("user-check.html");
	}
	
	
	//通过审核
	public void examine(){
		getModel(User.class).set("id", getPara("id")).set("status", 1).update();
		renderText("审核成功！");
	}
	
	//打印
	public void printer(){
		
		String fileName = "";
		int id = getParaToInt("id");
		try {
			fileName = WriteToDocx.write(id);
		} catch (IOException e) {
			e.printStackTrace();
		}
		renderFile(new File(fileName));
	}
	//超级管理员列表
	public void adminList(){
		setAttr("adminList", Admin.dao.getAllAdmin());
		render("admin-list.html");
	}
	
	//渲染添加管理员页面
	public void addAdmin(){
		render("admin-add.html");
	}
	
	//添加管理员方法
	public void adminadd(){
		//设置注册时间和默认注册状态
		//添加管理员注册名称不能重复
		String reg_date = DateUtils.unixTimestampToDate(DateUtils.dateToUnixTimestamp(DateUtils.getNowTime()));
		String pwd = MD5.GetMD5Code(getPara("user.pwd")+reg_date);
		getModel(Admin.class).set("pwd", pwd).set("create_time",reg_date).set("status", 1).save();
		renderText("添加管理员成功！"+getPara("admin.name"));
	}
	
	
	//县区市管理员列表
	public void countryadminList(){
		setAttr("caList", Admin.dao.getAllCountryAdmin());
		render("countryadminlist.html");
	}
	
	//数据库备份
	public void dbbackup(){
		render("system-data.html");
	}
	
	public void backupalldb(){
		String file_name = DateUtils.getNowTime("yymmdd");
		JavaMysqlUtil.backup("1.sql");
		renderFile("E:\\1.sql");
	}
	
	public void log(){
		setAttr("logList", Log.dao.getAllLog());
		render("system-log.html");
	}
	
	
	
}
