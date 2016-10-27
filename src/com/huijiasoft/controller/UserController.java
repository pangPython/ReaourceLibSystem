package com.huijiasoft.controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import com.huijiasoft.interceptor.UserAuthInterceptor;
import com.huijiasoft.model.Area;
import com.huijiasoft.model.Degree;
import com.huijiasoft.model.Edu;
import com.huijiasoft.model.Mz;
import com.huijiasoft.model.UploadPhoto;
import com.huijiasoft.model.Uploads;
import com.huijiasoft.model.User;
import com.huijiasoft.model.Zzmm;
import com.huijiasoft.utils.ControllerUtils;
import com.huijiasoft.utils.DBUtils;
import com.huijiasoft.utils.DateUtils;
import com.huijiasoft.utils.MD5;
import com.huijiasoft.utils.PathUtils;
import com.huijiasoft.utils.RenderDocxTemplate;
import com.huijiasoft.validate.UserUpdateValidator;
import com.jfinal.aop.Before;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.ext.kit.SessionIdKit;
import com.jfinal.kit.PathKit;
import com.jfinal.upload.UploadFile;
import com.oreilly.servlet.MultipartRequest;

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

		setAttr("user", user);
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
		setAttr("areaList", Area.dao.getAllArea());
		setAttr("nationList", Mz.dao.getAllMz());
		setAttr("zzmmList", Zzmm.dao.getAllZzmm());
		setAttr("eduList", Edu.dao.getAllEdu());
		setAttr("degreeList", Degree.dao.getAllDegree());

		render("edit.html");
	}

	// 修改个人信息
	@Before(UserUpdateValidator.class)
	@ActionKey("/user/updateinfo")
	public void updateinfo() {
		User user = (User) getSession().getAttribute(getCookie("cuser"));
		getModel(User.class).set("id", user.getId()).set("status", 0).update();
		user = User.usermodel.findById(user.getId());
		setSessionAttr(getCookie("cuser"), user);
		renderText("修改成功！");
	}

	public void media_upload() {

	}

	// 用户上传媒体文件
	public void upload() {
	}

	// 上传一寸照片
	public void upload_person_photo() {
		User user = getSessionAttr(getCookie("cuser"));
		user.setPhotoPath(getFile().getFileName());
		user.update();
		renderText("上传成功！");

	}
	
	//显示用户上传的图片文件
	public void media_pic() {
		User user = getSessionAttr(getCookie("cuser"));
		String path = PathKit.getWebRootPath() + "\\upload\\photo\\" + user.getMediaPath() + "\\";
		List<String> list = PathUtils.getAllFilePath(path);

		if(list==null){
			renderText("您未上传图片资料!");
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
	@ActionKey("/user/upload_pic")
	public void upload_pic() throws IOException {
		User user = getSessionAttr(getCookie("cuser"));

		String picture_upload_path = user.getMediaPath();

		// 处理上传路径
		if (!PathUtils.createNotExist(PathKit.getWebRootPath() + "\\upload\\photo\\" + picture_upload_path)) {
			renderText("上传路径出错!");
			return;
		}

		// 处理多文件上传
		getFiles("\\photo\\" + picture_upload_path, MAXSize, "utf-8");

		renderText("图片资料上传成功！");

	}

	// 显示用户审核是否通过的管理员消息
	public void msg() {
		User user = getSessionAttr(getCookie("cuser"));
		if (user.getStatus() == 1) {
			render("msg-success.html");
			return;
		} else {
			render("msg-failed.html");
			return;
		}
	}

	//显示用户上传的音频文件
	public void media_audio() {
		User user = getSessionAttr(getCookie("cuser"));
		// int user_id = user.getId();
		String path = PathKit.getWebRootPath() + "\\upload\\audio\\" + user.getMediaPath() + "\\";
		List<String> list = PathUtils.getAllFilePath(path);

		if(list==null){
			renderText("您未上传音频资料!");
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
			renderText("上传路径出错!");
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
			renderText("您未上传视频文件！");
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
			renderText("上传路径出错!");
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
		renderFile(new File("WebRoot\\download\\application\\东营市文化艺术人才信息登记表.doc"));
	}

	public void download_my() {
		User user = getSessionAttr(getCookie("cuser"));

		if (DBUtils.RecordAttrHasNull(user)) {
			renderText("你的报名信息不完整,请先完善信息！");
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
