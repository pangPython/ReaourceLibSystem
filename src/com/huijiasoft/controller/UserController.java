package com.huijiasoft.controller;

import java.util.List;

import com.huijiasoft.interceptor.UserAuthInterceptor;
import com.huijiasoft.model.Area;
import com.huijiasoft.model.DeclareType;
import com.huijiasoft.model.Degree;
import com.huijiasoft.model.Edu;
import com.huijiasoft.model.Mz;
import com.huijiasoft.model.User;
import com.huijiasoft.model.Zzmm;
import com.jfinal.aop.Before;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;

/**
 * @author pangPython
 *
 */
@Before(UserAuthInterceptor.class)
public class UserController extends Controller {
	
	 private final int MAXSize = 50 * 1024 * 1024; // 50M
	 private String filedir="";//指定用户训练视频文件上传路径
	
	
	public void index() {
		//使用客户端请求中的cookie中的user的唯一标识作为key
		//取服务器端的session
		User user = (User) getSession().getAttribute(getCookie("cuser"));
		
			setAttr("user", user);
			
			if(user.getAge()==null || user.getDecId()==null || user.getCard()==null){
				redirect("/adduserinfopage");
				
			}else{
				
				render("/user.html");
			}
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
		
		// upFiles.
		// 显示图片
		render("/showmedia.html");
	}
	
	
	
	

}
