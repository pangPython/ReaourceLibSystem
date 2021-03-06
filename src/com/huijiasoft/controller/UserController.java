package com.huijiasoft.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.huijiasoft.interceptor.UserAuthInterceptor;
import com.huijiasoft.model.Area;
import com.huijiasoft.model.DeclareType;
import com.huijiasoft.model.Degree;
import com.huijiasoft.model.Edu;
import com.huijiasoft.model.Msg;
import com.huijiasoft.model.Mz;
import com.huijiasoft.model.Uploads;
import com.huijiasoft.model.User;
import com.huijiasoft.model.Zzmm;
import com.huijiasoft.utils.ControllerUtils;
import com.huijiasoft.utils.DBUtils;
import com.huijiasoft.utils.MD5;
import com.huijiasoft.utils.PathUtils;
import com.huijiasoft.utils.RenderDocxTemplate;
import com.huijiasoft.validate.UserUpdateValidator;
import com.jfinal.aop.Before;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.kit.PathKit;

/**
 * @author pangPython 用户控制器
 */
@Before(UserAuthInterceptor.class)
public class UserController extends Controller {

	private final int MAXSize = 50 * 1024 * 1024; // 5M

	public void index() {

		User user = getSessionAttr(getCookie("cuser"));
		setAttr("user", user);

		render("index.html");
	}

	// 中心
	public void welcome() {
		User user = getSessionAttr(getCookie("cuser"));
		setAttr("user", user);
		render("welcome.html");
	}

	// 用户信息查看
	public void info() {
		User user = (User) getSessionAttr(getCookie("cuser"));
		String area = " ";
		String mz = " ";
		String zzmm = " ";
		String dec = " ";
		String fedu = " ";
		String pedu = " ";
		String fdegree = " ";
		String pdegree = " ";
		String feduscho = " ";
		String peduscho = " ";
		String fdegreescho =" ";
		String pdegreescho = " ";
		
		setAttr("user", user);
		
		try {
			area = Area.dao.getAreaNameById(user.getAreaId());
			mz = Mz.dao.getMzNameById(user.getMzId());
			zzmm = Zzmm.dao.getZzmmNameById(user.getZzmmId());
			dec = DeclareType.dao.getDecNameById(user.getDecId());
			
			fedu = Edu.dao.getEduNameById(user.getFEduId());
			pedu = Edu.dao.getEduNameById(user.getPEduId());
			fdegree = Degree.dao.getDegreeNameById(user.getFDegreeId());
			pdegree = Degree.dao.getDegreeNameById(user.getPDegreeId());
			feduscho = user.getFEduSchool();
			peduscho = user.getPEduSchool();
			fdegreescho = user.getFDegreeSchool();
			pdegreescho = user.getPDegreeSchool();
					
		} catch (Exception e) {
		}
		
		setAttr("fedu", fedu);
		setAttr("pedu", pedu);
		setAttr("fdegree", fdegree);
		setAttr("pdegree", pdegree);
		setAttr("feduscho", feduscho);
		setAttr("peduscho", peduscho);
		setAttr("fdegreescho", fdegreescho);
		setAttr("pdegreescho", pdegreescho);
		
		setAttr("area", area);
		setAttr("mz", mz);
		setAttr("zzmm", zzmm);
		setAttr("dec", dec);
		render("info.html");
		
	}

	// 已经登录用户的退出操作
	public void logout() {
		removeSessionAttr(getCookie("cuser"));
		removeCookie("cuser");
		redirect("/");
	}

	// 个人音频视频资料
	public void mediainfo() {
		User user = (User) getSession().getAttribute(getCookie("cuser"));
		setAttr("user", user);
		setAttr("mediaList", Uploads.dao.getAllMediaById(user.getId().toString()));
		render("/mediainfo.html");
	}

	
	//用户更新信息
	
	public void edit() {
		User user = (User) getSession().getAttribute(getCookie("cuser"));

		setAttr("user", user);
		setAttr("area", Area.dao.getAreaNameById(user.getAreaId().toString()));
		setAttr("areaList", Area.dao.getAllArea());
		setAttr("nationList", Mz.dao.getAllMz());
		setAttr("zzmmList", Zzmm.dao.getAllZzmm());
		setAttr("eduList", Edu.dao.getAllEdu());
		setAttr("degreeList", Degree.dao.getAllDegree());
		setAttr("decList", DeclareType.dao.getAllDecType());

		render("edit.html");
	}

	// 修改个人信息
	@Before(UserUpdateValidator.class)
	@ActionKey("/user/updateinfo")
	public void updateinfo() {
		//异常处理
		String media_path = " ";
		
		try {
			media_path = getFile().getFileName();
		} catch (Exception e) {
			
		}
		
		User user = (User) getSession().getAttribute(getCookie("cuser"));

		String f_edu_school = " ";
		String f_degree_school = " ";
		String p_edu_school = " ";
		String p_degree_school = " ";
		
		int f_edu_id = getParaToInt("user.f_edu_id");
		int f_degree_id = getParaToInt("user.f_degree_id");
		int p_edu_id = getParaToInt("user.p_edu_id");
		int p_degree_id = getParaToInt("user.p_degree_id");
		
		try {
			if(f_edu_id!=0){
				f_edu_school = getPara("user.f_edu_school");
			}
			if(f_degree_id!=0){
				f_degree_school = getPara("user.f_degree_school");
			}
			if(p_edu_id!=0){
				p_edu_school = getPara("user.p_edu_school");
			}
			if(p_degree_id!=0){
				p_degree_school = getPara("user.p_degree_school");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		User u = getModel(User.class);
		u.set("id", user.getId());
		u.set("status", 0);
		u.setPhotoPath(media_path);
		
		u.setFDegreeId(f_degree_id);
		u.setFEduId(f_edu_id);
		u.setPDegreeId(p_degree_id);
		u.setPEduId(p_edu_id);
		
		u.setFDegreeSchool(f_degree_school);
		u.setFEduSchool(f_edu_school);
		u.setPDegreeSchool(p_degree_school);
		u.setPEduSchool(p_edu_school);
		
		
		u.update();
		
		user = User.usermodel.findById(user.getId());
		setSessionAttr(getCookie("cuser"), user);
		renderText("信息填写成功,将自动提交审核！");
	}

//上传路径的文件系统分隔符要做跨平台linux--/  windows--\ 
	
	//显示用户上传的图片文件
	public void media_pic() {
		User user = getSessionAttr(getCookie("cuser"));
		String path = PathKit.getWebRootPath() + "\\upload\\photo\\" + user.getMediaPath() + "\\";
		List<String> list = PathUtils.getAllFilePath(path);

		if(list==null){
			setAttr("ErrMsg", "您未上传图片资料!");
			render("error.html");
			return;
		}
		
		setAttr("picList", list);
		setAttr("user", user);
		render("media_pic.html");
	}



	// 显示页面
	public void media_pic_upload() {
	}

	// 多图片上传
	@ActionKey("/user/uploadpic")
	public void uploadpic() throws IOException {
		User user = getSessionAttr(getCookie("cuser"));

		String picture_upload_path = user.getMediaPath();

		// 处理上传路径
		if (!PathUtils.createNotExist(PathKit.getWebRootPath() + "\\upload\\photo\\" + picture_upload_path)) {
			setAttr("ErrMsg", "上传路径出错!");
			render("error.html");
			return;
		}

		// 处理多文件上传
		getFiles("\\photo\\" + picture_upload_path, MAXSize, "utf-8");

		renderText("图片资料上传成功！");

	}
	
	//删除图片
	public void delpic(){
		boolean flag = false;
		User user = User.usermodel.findById(getPara("uid"));
		//获取图片路径
		String upath = PathKit.getWebRootPath()+"\\upload\\photo\\"+user.getMediaPath()+"\\";
		//获取用户提交的要删除的文件名
		String[] pic_name = getParaValues("filename[]");
		File file = null;
		
		if(pic_name==null){
			renderNull();
			return;
		}
		
		for (int i = 0; i < pic_name.length; i++) {
			file = new File(upath+pic_name[i]);
			
			if(!file.exists()){
				//文件不存在
				renderJson("{\"status\":0,\"errmsg\":\"文件不存在！\"}");
				return;
			}else{
				if(!file.isFile()){
					//不是文件
					renderJson("{\"status\":0,\"errmsg\":\"不是文件！\"}");
					return;
				}
					if(file.delete()){
						flag = true;
					}else{
						flag = false;
					}
			}
			
		}
		
		if(flag){
			renderJson("{\"status\":1}");
		}else{
			renderJson("{\"status\":0,\"errmsg\":\"未知错误！\"}");
		}
	}
	
	//删除音频文件
	public void delaudio(){

		boolean flag = false;
		User user = User.usermodel.findById(getPara("userid"));
		//获取图片路径
		String upath = PathKit.getWebRootPath()+"\\upload\\audio\\"+user.getMediaPath()+"\\";
		//获取用户提交的要删除的文件名
		String audio_name = getPara("filename");
		File file = null;
		
			file = new File(upath+audio_name);
			
			if(!file.exists()){
				//文件不存在
				renderJson("{\"status\":0,\"errmsg\":\"文件不存在！\"}");
				return;
			}else{
				if(!file.isFile()){
					//不是文件
					renderJson("{\"status\":0,\"errmsg\":\"不是文件！\"}");
					return;
				}
					if(file.delete()){
						flag = true;
					}else{
						flag = false;
					}
			}
			

		
		if(flag){
			renderJson("{\"status\":1}");
		}else{
			renderJson("{\"status\":0,\"errmsg\":\"未知错误！\"}");
		}
	}
	
	
	//删除视频文件
	public void delvideo(){

		boolean flag = false;
		User user = User.usermodel.findById(getPara("userid"));
		//获取图片路径
		String upath = PathKit.getWebRootPath()+"\\upload\\video\\"+user.getMediaPath()+"\\";
		//获取用户提交的要删除的文件名
		String audio_name = getPara("filename");
		File file = null;
		
			file = new File(upath+audio_name);
			
			if(!file.exists()){
				//文件不存在
				renderJson("{\"status\":0,\"errmsg\":\"文件不存在！\"}");
				return;
			}else{
				if(!file.isFile()){
					//不是文件
					renderJson("{\"status\":0,\"errmsg\":\"不是文件！\"}");
					return;
				}
					if(file.delete()){
						flag = true;
					}else{
						flag = false;
					}
			}
			

		
		if(flag){
			renderJson("{\"status\":1}");
		}else{
			renderJson("{\"status\":0,\"errmsg\":\"未知错误！\"}");
		}
	}

	// 显示用户审核是否通过的管理员消息
	public void msg() {
		User user = getSessionAttr(getCookie("cuser"));
		if (user.getStatus() == 1) {
			render("msg-success.html");
			return;
		} else {
			try {
				//审核未通过,要显示失败信息
				Msg m = Msg.dao.findByUserId(user.getId());
				
				if(m==null){
					renderText("请提交资料后耐心等待审核...");
					return;
				}
				setAttr("Msg", m);
				render("msg-failed.html");
				return;
			} catch (Exception e) {
				//当管理员还未审核时
				renderText("请提交资料后耐心等待审核...");
				return;
			}
		}
	}

	//显示用户上传的音频文件
	public void media_audio() {
		User user = getSessionAttr(getCookie("cuser"));
		// int user_id = user.getId();
		String path = PathKit.getWebRootPath() + "\\upload\\audio\\" + user.getMediaPath() + "\\";
		List<String> list = PathUtils.getAllFilePath(path);

		if(list==null){
			setAttr("ErrMsg", "您未上传音频资料!");
			render("error.html");
			return;
		}
		
		setAttr("audioList", list);
		setAttr("user", user);
		render("media_audio.html");
	}

	public void media_audio_upload() {
		
	}
	
	public void upload_audio() {
		User user = getSessionAttr(getCookie("cuser"));

		String picture_upload_path = user.getMediaPath();

		// 处理上传路径
		if (!PathUtils.createNotExist(PathKit.getWebRootPath() + "\\upload\\audio\\" + picture_upload_path)) {
			setAttr("ErrMsg", "上传路径出错!");
			render("error.html");
			return;
		}

		// 处理多文件上传
		getFiles("\\audio\\" + picture_upload_path, MAXSize, "utf-8");

		renderText("音频资料上传成功！");

	}

	public void media_video() {
		User user = getSessionAttr(getCookie("cuser"));
		// int user_id = user.getId();
		String path = PathKit.getWebRootPath() + "\\upload\\video\\" + user.getMediaPath() + "\\";
		List<String> list = PathUtils.getAllFilePath(path);
		
		//如果文件夹为空
		if(list==null){
			setAttr("ErrMsg", "您未上传视频文件！");
			render("error.html");
			return;
		}
		
		setAttr("videoList", list);
		setAttr("user", user);
		render("media_video.html");

	}

	public void media_video_upload() {
		
	}
	
	public void upload_video(){
		User user = getSessionAttr(getCookie("cuser"));

		String picture_upload_path = user.getMediaPath();

		// 处理上传路径
		if (!PathUtils.createNotExist(PathKit.getWebRootPath() + "\\upload\\video\\" + picture_upload_path)) {
			setAttr("ErrMsg", "上传路径出错!");
			render("error.html");
			return;
		}

		// 处理多文件上传
		getFiles("\\video\\" + picture_upload_path, MAXSize, "utf-8");

		renderText("视频资料上传成功！");
	}

	public void application_std() {
	}

	public void application_my() {
	}

	// 下载标准报名表
	@ActionKey("/user/download_std")
	public void download_std() {
		
		renderFile(new File("WebRoot\\1.doc"));
	}

	public void download_my() {
		User user = getSessionAttr(getCookie("cuser"));

		if (DBUtils.RecordAttrHasNull(user)) {
			setAttr("ErrMsg", "你的报名信息不完整,请先完善信息！");
			render("error.html");
			return;
		}

		String file_name = RenderDocxTemplate.creatWord(user);
		renderFile(new File(file_name));
	}

	// 显示修改密码页面
	public void change_pwd() {
		User user = (User) ControllerUtils.getMFromSbyIdinC(this, "cuser");
		setAttr("user", user);
		render("change_pwd.html");
	}

	// 修改密码
	// TODO
	public void updatepwd() {

		User user = (User) ControllerUtils.getMFromSbyIdinC(this, "cuser");
		// 验证码
		boolean yzm = this.validateCaptcha("yzm");
		if (!yzm) {

			setAttr("user", user);
			setAttr("yzmErrMsg", "请正确输入验证码！");
			render("change_pwd.html");
			return;
		}

		String reg_time = user.getRegDate();

		// 验证原密码
		String old_pwd = MD5.GetMD5Code(getPara("oldpwd") + reg_time);
		if (!user.getPwd().equals(old_pwd)) {
			setAttr("user", user);
			setAttr("oldpwdErrMsg", "请正确输入原密码！");
			render("change_pwd.html");
			return;
		}

		// 比对确认密码
		String new_pwd = getPara("newpwd");
		String confirm_new_pwd = getPara("confirmnewpwd");

		if (!new_pwd.equals(confirm_new_pwd)) {
			setAttr("user", user);
			setAttr("confirmpwdErrMsg", "请正确输入新密码！");
			render("change_pwd.html");
			return;
		}

		// 新旧密码是否相同
		new_pwd = MD5.GetMD5Code(new_pwd + reg_time);

		if (new_pwd.equals(old_pwd)) {
			setAttr("user", user);
			setAttr("newpwdErrMsg", "旧密码与新密码相同！");
			render("change_pwd.html");
			return;
		}

		// 修改密码
		user.setPwd(new_pwd);
		user.update();
		renderText("密码更改成功！");

	}

}
