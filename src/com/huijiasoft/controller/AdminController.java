package com.huijiasoft.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

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
import com.huijiasoft.service.IndexService;
import com.huijiasoft.utils.DateUtils;
import com.huijiasoft.utils.JavaMysqlUtil;
import com.huijiasoft.utils.MD5;
import com.huijiasoft.utils.ReportExcel;
import com.huijiasoft.utils.WriteToDocx;
import com.huijiasoft.validate.AdminValidator;
import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.ext.kit.SessionIdKit;
import com.jfinal.kit.PathKit;


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
				setAttr("system", IndexService.getSysConfig());
				render("login.html");
				return;
			}
			
			//debug
		
			
			if(!admin.getPwd().equals(admin_pwd)){
				setAttr("LoginNameMsg","用户名或密码错误！");
				setAttr("system", IndexService.getSysConfig());
				render("login.html");
				return;
			}
			
			//生成唯一标识 会话控制
			String sessionId = SessionIdKit.me().generate(getRequest());
			//设置服务器端session
			setSessionAttr(sessionId, admin);
			//设置用户端cookie
			setCookie("cadmin", sessionId, 60000);
			
			
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
			setAttr("system", IndexService.getSysConfig());
			render("login.html");
			
		}
		
	}
	
	
	//县区管理员主页
	public void xqadmin(){
		
		render("countryadmin.html");
	}
	
	
	//县区管理员搜索
	public void xqsearch(){
		Admin admin = getSessionAttr(getCookie("cadmin"));
		setAttr("userList", User.usermodel.getUserByAreaId(admin.getAreaId()));
		render("xqsearch.html");
	}
	
	
	
	//退出方法
	public void logout(){
		removeSessionAttr(getCookie("cadmin"));
		redirect("index");
	}
	
	//后台服务器信息总览页面
	public void welcome() {
		Admin admin = getSessionAttr(getCookie("cadmin"));
		setAttr("admin", admin);
		render("welcome.html");
	}
	
	//后台搜索页面
	public void search(){
		setAttr("userList", User.usermodel.getAllUser());
		render("article-list.html");
	}
	
	public void useraddpage(){
		setAttr("areaList", Area.dao.getAllArea());
		setAttr("nationList", Mz.dao.getAllMz());
		setAttr("zzmmList", Zzmm.dao.getAllZzmm());
		setAttr("eduList", Edu.dao.getAllEdu());
		setAttr("degreeList", Degree.dao.getAllDegree());
		render("user-add.html");
	}
	
	public void adduser(){
		User user = getModel(User.class);
		String reg_time = DateUtils.dateToUnixTimestamp(DateUtils.getNowTime())+"";
		user.setRegDate(reg_time);
		user.save();
		renderText("添加成功！");
	}
	
	//审核参数设置
	public void examineset(){
		render("set-examine.html");
	}
	
	//附件参数设置
	public void attachmentset(){
		render("set-attachment.html");
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
		
		List<Mz> nationList = Mz.dao.getAllMz();
		String listsize = nationList.size()+"";
		setAttr("nationList", nationList);
		setAttr("listsize", listsize);
		render("nation.html");
	}
	
	//民族编辑页面
	public void nationedit(){
		setAttr("nation", Mz.dao.findById(getPara("id")));
		render("mzedit.html");
	}
	
	//民族字段更新
	public void nationupdate(){
		Mz.dao.set("mz_id", getPara("mz_id")).set("mzname", getPara("mzname")).update();
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
		String reg_date = DateUtils.getNowTime();
		String pwd = MD5.GetMD5Code(getPara("admin.pwd")+reg_date);
		
		getModel(Admin.class).set("pwd", pwd).set("create_time",reg_date).set("status", 1).save();
		renderText("添加管理员成功！"+getPara("admin.name"));
	}
	
	
	//县区市管理员列表
	public void countryadminList(){
		setAttr("caList", Admin.dao.getAllCountryAdmin());
		render("countryadminlist.html");
	}
	
	//数据库备份页面
	public void dbbackup(){
		render("system-data.html");
	}
	
	//备份处理方法
	@ActionKey("/admin/backupalldb")
	public void backupalldb(){
		String file_name = DateUtils.dateToUnixTimestamp(DateUtils.getNowTime())+".sql";
		JavaMysqlUtil.backup(file_name);
		renderFile(new File("WebRoot\\download\\dbbackup\\"+file_name));
	}
	
	//获取所有管理员登录日志
	public void log(){
		setAttr("logList", Log.dao.getAllLog());
		render("system-log.html");
	}
	
	public void reportpage(){
		render("report.html");
	}
	
	//报表
	public void excelall(){
		List<User> userlist = User.usermodel.getAllUser();
		String filename = "";
		try {
			filename = ReportExcel.report(userlist);
		} catch (IOException e) {
			e.printStackTrace();
		}
		renderFile(new File(filename));
	}
	
	//管理员查看用户图片资料
	public void userphoto(){
		
		render("u-photo.html");
	}
	
	//管理员查看用户音频资料
	public void useraudio(){
		render("u-audio.html");
	}
	//管理员查看用户音频资料
	public void uservideo(){
		render("u-video.html");
	}
	
	//用户审核是否通过的消息
	public void message(){
		render("message.html");
	}
	
	
}
