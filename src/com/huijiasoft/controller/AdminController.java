package com.huijiasoft.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.huijiasoft.utils.DBUtils;
import com.huijiasoft.utils.DateUtils;
import com.huijiasoft.utils.JavaMysqlUtil;
import com.huijiasoft.utils.MD5;
import com.huijiasoft.utils.PathUtils;
import com.huijiasoft.utils.RenderDocxTemplate;
import com.huijiasoft.utils.ReportExcel;
import com.huijiasoft.validate.AdminValidator;
import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.ext.kit.SessionIdKit;
import com.jfinal.kit.PathKit;
import com.jfinal.upload.UploadFile;


/**
 * @author pangPython
 *	后台控制器
 */
@Before(AdminAuthInterceptor.class)
public class AdminController extends Controller {
	
	public void index(){
		setAttr("admin", getSessionAttr(getCookie("cadmin")));
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
		
		//验证码验证
				boolean result = validateCaptcha("verifycode");
				if(!result){
					setAttr("codeMsg","验证码错误！");
					setAttr("system", IndexService.getSysConfig());
					render("login.html");
					return;
				}
		
		
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
	
	//县区管理员welcome页面
	public void xqwelcome(){
		Admin admin = getSessionAttr(getCookie("cadmin"));
		setAttr("xqadmin", admin);
		render("xq-welcome.html");
		
	}
	
	//后台搜索页面
	public void search(){
		setAttr("userList", User.usermodel.getAllUser());
		render("article-list.html");
	}
	
	//条件查询
	public void searchuser(){
		
		setAttr("areaList", Area.dao.getAllArea());
		setAttr("nationList", Mz.dao.getAllMz());
		setAttr("zzmmList", Zzmm.dao.getAllZzmm());
		setAttr("eduList", Edu.dao.getAllEdu());
		setAttr("degreeList", Degree.dao.getAllDegree());
		setAttr("decList", DeclareType.dao.getAllDecType());
		
		render("search-user.html");
	}
	

	
	
	//执行查询
	public void uschbycondition(){
		Map<String,Object> map = new HashMap<String, Object>();
		String sex = getPara("user.usersex");
		String mz_id = getPara("user.mz_id");
		String area_id = getPara("user.area_id");
		String zzmm_id = getPara("user.zzmm_id");
		String dec_id = getPara("user.dec_id");
		if(sex!=null && !sex.equals("")){
			map.put("user.usersex", sex);
		}
		if(mz_id!=null && !mz_id.equals("")){
			map.put("user.mz_id", mz_id);
		}
		if(area_id!=null && !area_id.equals("")){
			map.put("user.area_id", area_id);
		}
		if(zzmm_id!=null && !zzmm_id.equals("")){
			map.put("user.zzmm_id", zzmm_id);
		}
		if(dec_id!=null && !dec_id.equals("")){
			map.put("user.dec_id", dec_id);
		}	
		
		List<User> userList = User.usermodel.getUserListByCondition(map);
		
		String filename = "";
		try {
			filename = ReportExcel.report(userList);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		File file =		new File(filename);
		String file_name = "";
		if(file!=null){
			file_name = file.getName();
		}
		
		setAttr("file", file_name);
		
		setAttr("userList", userList);
		
		render("s-u-result.html");
	}
	
	
	//县区管理员进行条件查询
	public void xqsearchuser(){

		setAttr("areaList", Area.dao.getAllArea());
		setAttr("nationList", Mz.dao.getAllMz());
		setAttr("zzmmList", Zzmm.dao.getAllZzmm());
		setAttr("eduList", Edu.dao.getAllEdu());
		setAttr("degreeList", Degree.dao.getAllDegree());
		setAttr("decList", DeclareType.dao.getAllDecType());
		render("xq-search-user.html");
	}
	
	
	//执行查询
		public void xquschbycondition(){
			Map<String,Object> map = new HashMap<String, Object>();
			String sex = getPara("user.usersex");
			String mz_id = getPara("user.mz_id");
			Admin admin = getSessionAttr(getCookie("cadmin"));
			String area_id = admin.getAreaId()+"";
			String zzmm_id = getPara("user.zzmm_id");
			String dec_id = getPara("user.dec_id");
			if(sex!=null && !sex.equals("")){
				map.put("user.usersex", sex);
			}
			if(mz_id!=null && !mz_id.equals("")){
				map.put("user.mz_id", mz_id);
			}
			if(area_id!=null && !area_id.equals("")){
				map.put("user.area_id", area_id);
			}
			if(zzmm_id!=null && !zzmm_id.equals("")){
				map.put("user.zzmm_id", zzmm_id);
			}
			if(dec_id!=null && !dec_id.equals("")){
				map.put("user.dec_id", dec_id);
			}	
			
			List<User> userList = User.usermodel.getUserListByCondition(map);
			
			String filename = "";
			try {
				filename = ReportExcel.report(userList);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			File file =		new File(filename);
			String file_name = "";
			if(file!=null){
				file_name = file.getName();
			}
			
			setAttr("file", file_name);
			
			setAttr("userList", userList);
			
			render("s-u-result.html");
		}
	
	
	public void useraddpage(){
		setAttr("areaList", Area.dao.getAllArea());
		setAttr("nationList", Mz.dao.getAllMz());
		setAttr("zzmmList", Zzmm.dao.getAllZzmm());
		setAttr("eduList", Edu.dao.getAllEdu());
		setAttr("degreeList", Degree.dao.getAllDegree());
		render("user-add.html");
	}
	
	//管理员添加用户
	public void adduser(){
		UploadFile upfile = getFile();
		
		if(upfile==null){
			setAttr("ErrMsg", "请上传一寸照片！");
			render("error.html");
			return;
		}
		
		String user_photo_name = upfile.getFileName();
		User user = getModel(User.class);
		String reg_time = DateUtils.getNowTime();
		String pwd = this.getPara("password");
		pwd = MD5.GetMD5Code(pwd+reg_time);
		user.setRegDate(reg_time);
		user.setPwd(pwd);
		user.setPhotoPath(user_photo_name);
		user.setUname(getPara("user.uname"));
		user.setStatus(1);
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
	
	//增加申报类别
	public void adddec(){
		render("dec-add.html");
	}
	//添加申报类别的方法
	public void decadd(){
		DeclareType dec = getModel(DeclareType.class);
		dec.set("decname", getPara("dec.name")).save();
		renderText("添加成功！");
				
	}
	//删除类别
	public void deldec(){
		DeclareType dec = getModel(DeclareType.class);
		if(dec.dao.deleteById(getParaToInt(0))){
			renderText("1");
		}else{
			renderText("0");
		}
		
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
	
	public void mzadd(){
		render("mz-add.html");
	}
	
	public void delmz(){
		Mz mz = getModel(Mz.class);
		if(mz.dao.deleteById(getParaToInt(0))){
			renderText("1");
		}else{
			renderText("0");
		}
		
	}
	
	public void addmz(){
		Mz mz = getModel(Mz.class);
		mz.set("mzname", getPara("mz.mzname")).save();
		renderText("添加成功！");
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
	
	public void delzzmm(){
		Zzmm zzmm = getModel(Zzmm.class);
		if(zzmm.dao.deleteById(getParaToInt(0))){
			renderText("1");
		}else{
			renderText("0");
		}
		
	}
	
	
	public void zzmmadd(){
		render("zzmm-add.html");
	}
	
	public void addzzmm(){
		Zzmm zzmm = getModel(Zzmm.class);
		zzmm.set("zzmmname", getPara("zzmm.zzmmname")).save();
		renderText("添加成功！");
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
	
	//
	public void eduadd(){
		render("edu-add.html");
	}
	
	
	public void deledu(){
		Edu edu = getModel(Edu.class);
		if(edu.dao.deleteById(getParaToInt(0))){
			renderText("1");
		}else{
			renderText("0");
		}
	}
	
	public void addedu(){
		Edu edu  = getModel(Edu.class);
		edu.set("eduname",getPara("edu.eduname")).save();
		renderText("添加成功！");
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
	
	public void deldegree(){
		Degree degree = getModel(Degree.class);
		if(degree.dao.deleteById(getParaToInt(0))){
			renderText("1");
		}else{
			renderText("0");
		}
	}
	
	
	public void degreeadd(){
		render("degree-add.html");
	}
	
	public void adddegree(){
		getModel(Degree.class).save();
		renderText("增加学位信息成功！");
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
	
	public void delarea(){
		Area area = getModel(Area.class);
		if(area.dao.deleteById(getParaToInt(0))){
			renderText("1");
		}else{
			renderText("0");
		}
	}
	
	
	public void areaadd(){
		render("area-add.html");
	}
	
	public void addarea(){
		getModel(Area.class).save();
		renderText("增加地区信息成功！");
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
		getModel(User.class).set("id", getParaToInt(0)).set("status", 1).update();
		renderText("审核成功！");
	}
	
	//打印
/*	public void printer(){
		
		String fileName = "";
		int id = getParaToInt("id");
		try {
			fileName = WriteToDocx.write(id);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		renderFile(new File(fileName));
	}
	*/
	
	//超级管理员列表
	public void adminList(){
		setAttr("adminList", Admin.dao.getAllAdmin());
		render("admin-list.html");
	}
	
	//渲染添加管理员页面
	public void addAdmin(){
		render("admin-add.html");
	}
	
	
	//编辑管理员信息
	public void editadmin(){
		Admin admin = Admin.dao.findById(getParaToInt(0));
		setAttr("admin", admin);
		render("admin-edit.html");
	}
	
	//管理员信息更新
	public void admininfoupdate(){
		Admin admin = Admin.dao.findById(getParaToInt(0));
		String create_time = admin.getCreateTime();
		
		String pwd = MD5.GetMD5Code(getPara("admin.pwd")+create_time);
		getModel(Admin.class)
		.set("id", admin.getId())
		.set("telephone", getPara("admin.telephone"))
		.set("email", getPara("admin.email"))
		.set("pwd", pwd)
		.update();
		admin = Admin.dao.findById(admin.getId());
		setSessionAttr(getCookie("cadmin"), admin);
		renderText("修改成功！");
	}
	
	//添加管理员方法
	public void adminadd(){
		//设置注册时间和默认注册状态
		//添加管理员注册名称不能重复
		String reg_date = DateUtils.getNowTime();
		String pwd = MD5.GetMD5Code(getPara("admin.pwd")+reg_date);
		
		getModel(Admin.class).set("pwd", pwd).set("create_time",reg_date).set("status", 1).save();
		renderText("添加管理员 "+getPara("admin.name")+" 成功！");
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
		renderText("备份成功！请使用FTP工具 下载。地址：WebRoot\\download\\dbbackup\\"+file_name);
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
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		renderFile(new File(filename));
	}
	
	//管理员查看用户图片资料
	public void userphoto(){
		
		User user = User.usermodel.findById(getPara(0));
		String path = PathKit.getWebRootPath() + "\\upload\\photo\\" + user.getMediaPath() + "\\";
		List<String> list = PathUtils.getAllFilePath(path);

		if(list==null){
			setAttr("ErrMsg", "该用户未上传图片资料!");
			render("error.html");
			return;
		}
		
		setAttr("picList", list);
		setAttr("user", user);
		render("u-photo.html");
	}
	
	//管理员查看用户音频资料
	public void useraudio(){
		
		User user = User.usermodel.findById(getPara(0));
		// int user_id = user.getId();
		String path = PathKit.getWebRootPath() + "\\upload\\audio\\" + user.getMediaPath() + "\\";
		List<String> list = PathUtils.getAllFilePath(path);

		if(list==null){
			setAttr("ErrMsg", "该用户未上传音频文件！");
			render("error.html");
			return;
		}
		
		setAttr("audioList", list);
		setAttr("user", user);
		
		render("u-audio.html");
	}
	//管理员查看用户音频资料
	public void uservideo(){
		
		User user = User.usermodel.findById(getPara(0));
		String path = PathKit.getWebRootPath() + "\\upload\\video\\" + user.getMediaPath() + "\\";
		List<String> list = PathUtils.getAllFilePath(path);
		
		//如果文件夹为空
		if(list==null){
			setAttr("ErrMsg", "该用户未上传视频文件！");
			render("error.html");
			return;
		}
		
		setAttr("videoList", list);
		setAttr("user", user);
		
		render("u-video.html");
	}
	
	//打印某个人才信息
	public void userinfoprint(){
		User user = User.usermodel.findById(getParaToInt(0));
		if(DBUtils.RecordAttrHasNull(user)){
			setAttr("ErrMsg", "该人才的报名信息不完整,请先完善信息！");
			render("error.html");
			return;
		}
		String file_name = RenderDocxTemplate.creatWord(user);
		renderFile(new File(file_name));
	}
	
	//用户审核是否通过的消息
	public void message(){
		render("message.html");
	}
	
	
}
