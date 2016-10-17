package com.huijiasoft.controller;

import java.util.List;

import com.huijiasoft.interceptor.UserAuthInterceptor;
import com.huijiasoft.model.Area;
import com.huijiasoft.model.DeclareType;
import com.huijiasoft.model.Degree;
import com.huijiasoft.model.Edu;
import com.huijiasoft.model.Mz;
import com.huijiasoft.model.Uploads;
import com.huijiasoft.model.User;
import com.huijiasoft.model.Zzmm;
import com.huijiasoft.utils.DateUtils;
import com.jfinal.aop.Before;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;

/**
 * @author pangPython
 *		用户控制器
 */
@Before(UserAuthInterceptor.class)
public class UserController extends Controller {
	
	 private final int MAXSize = 50 * 1024 * 1024; // 5M
	
	public void index() {
		User user = getSessionAttr(getCookie("cuser"));
		setAttr("user",user);
		render("index.html");
	}
	
	//中心
	public void welcome(){
		User user = getSessionAttr(getCookie("cuser"));
		setAttr("user", user);
		render("welcome.html");
	}
	
	
	//用户中心方法
	public void center() {
		User user = (User) getSession().getAttribute(getCookie("cuser"));
		
		setAttr("user", user);
		render("/center.html");
	}
	//已经登录用户的退出操作
	public void logout(){
		removeSessionAttr(getCookie("cuser"));
		removeCookie("cuser");
		redirect("/");
	}
	
	//个人音频视频资料
	public void mediainfo(){
		User user = (User) getSession().getAttribute(getCookie("cuser"));
		setAttr("user", user);
		setAttr("mediaList", Uploads.dao.getAllMediaById(user.getId().toString()));
		render("/mediainfo.html");
	}
	
	
	public void edit(){
		User user = (User) getSession().getAttribute(getCookie("cuser"));
		setAttr("user", user);
		render("/editinfo.html");
	}
	
	@ActionKey("/adduserinfo")
	public void adduserinfo(){
		User user = (User) getSession().getAttribute(getCookie("cuser"));
		getModel(User.class).set("id", user.getId()).set("status", 0).update();
		setAttr("user", user);
		render("/sbmtsucc.html");
	}
	
	@ActionKey("/adduserinfopage")
	public void adduserinfopage(){
		User user = (User) getSession().getAttribute(getCookie("cuser"));
		
		setAttr("user", user);
		List<Area> area = Area.dao.getAllArea();
		List<Mz> minzu = Mz.dao.getAllMz();
		List<Zzmm> zzmmList = Zzmm.dao.getAllZzmm();
		List<Edu> eduList = Edu.dao.getAllEdu();
		List<Degree> degreeList = Degree.dao.getAllDegree();
		List<DeclareType> decList = DeclareType.dao.getAllDecType();
		
		setAttr("area", area);
		setAttr("minzuList",minzu);
		setAttr("zzmmList", zzmmList);
		setAttr("eduList", eduList);
		setAttr("degreeList",degreeList);
		setAttr("decList", decList);
		render("/adduserinfo.html");
	}
	
	
	// 用户上传媒体文件
	public void upload() {
		// 批量上传文件
		List<UploadFile> upFiles = getFiles("./", MAXSize, "utf-8");
		// 写入数据库
		User user = getSessionAttr(getCookie("cuser"));
		int user_id = user.getId();
		
		
		//遍历文件list
		Uploads uploads = getModel(Uploads.class);
		for (int i = 0; i < upFiles.size(); i++) {
			uploads.setUserId(user_id);
			uploads.setPath(upFiles.get(i).getFileName());
			uploads.setType("1");
			uploads.setCreateTime(DateUtils.getNowTime());
			uploads.save();
			
		}
	
		// 显示图片
		setAttr("user", user);
		redirect("showmedia?id="+user.getId());
	}
	
	//上传一寸半身照
	public void uploadphoto(){
		UploadFile file = getFile();
		
		if(file == null){
			render("sbmtsucc.html");
		}
		//保存照片路径
		User user = getSessionAttr(getCookie("cuser"));
		user.setPhotoPath(file.getFileName());
		user.update();
		
		
		redirect("showmedia");
		
	}
	
	
	//个人媒体资料展示页面
	public void showmedia(){
		User user = getSessionAttr(getCookie("cuser"));
		setAttr("user", user);
		setAttr("mediaList", Uploads.dao.getAllMediaById(getPara("id")));
		
		render("/showmedia.html");
	}
	
	
	public void baomingbiao(){
		int uid = getParaToInt("id");
		User user = User.usermodel.findById_Relation(uid);
		String mzname = user.getStr("mzname");
		setAttr("user", user);
		setAttr("mz", mzname);
		setAttr("zzmm", user.getStr("zzmmname"));
		render("/baomingbiao.html");
	}
	
	
	

}
