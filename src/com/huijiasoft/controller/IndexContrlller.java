package com.huijiasoft.controller;



import com.huijiasoft.model.User;
import com.huijiasoft.service.IndexService;
import com.huijiasoft.utils.DateUtils;
import com.huijiasoft.utils.MD5;
import com.huijiasoft.validate.RegistValidator;
import com.jfinal.aop.Before;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.ext.kit.SessionIdKit;

/**
 * @author pangPython
 *	前端控制器
 */

public class IndexContrlller extends Controller {
	
	//进入首页
	
	@ActionKey("/")
	public void index(){
		redirect("loginpage");
	}
	
	
	public void loginpage(){
		String cuser = getCookie("cuser");
		if(cuser!=null){
			redirect("user");
		}
		
			setAttr("system", IndexService.getSysConfig());
			render("login.html");
	}
	
	//前台登录方法
	public void login(){
		//如果请求参数cookie中获取当前登录用户
		String cuser = getCookie("cuser");
		User u = getSessionAttr(cuser);
		
		if(u!=null){
			redirect("/user");
		}
		
		//验证码结果
		boolean result = validateCaptcha("verifycode");
		if(!result){
			setAttr("yzmErrMsg", "验证码错误！");
			setAttr("system", IndexService.getSysConfig());
			render("login.html");
			return;
		}
		
		String uname = getPara("uname");
		String sql = "select * from user where uname = ? limit 1";

		User user = User.usermodel.findFirst(sql,uname);
		if(user!=null){
			String pwd = MD5.GetMD5Code(getPara("password")+user.getRegDate());
			
			if(user.getPwd().equals(pwd)){
				
				//生成唯一标识
				String sessionId = SessionIdKit.me().generate(getRequest());
				//设置服务器端session
				setSessionAttr(sessionId, user);
				//设置用户端cookie
				setCookie("cuser", sessionId, 600);
				redirect("/user");
				
			}else{
				//密码不正确
				redirect("loginpage");
				
			}
			
		}else{
			//用户名不存在
			redirect("loginpage");
		}
		
		
	}
	
	//注册
	
	public void register(){
		render("regist.html");
	}
	
	
	@ActionKey("regist")
	@Before(RegistValidator.class)
	public void regist(){
		String mima = getPara("user.pwd");
		String confirm = getPara("reg.confirmpwd");
		
		if(!confirm.equals(mima)){
			setAttr("confirmMsg", "请再次输入正确密码！");
			return;
		}
		
		
		String uname = getPara("user.uname");
		User user = this.getModel(User.class);
		//如果用户名已经被注册，提示错误信息
		if(user.findFirst("select * from user where uname = ?",uname)!=null){
			setAttr("unameMsg", "该用户名已被注册");
			render("regist.html");
		}else{
		//使用工具包把当前时间转换成unix时间戳再转换成string类型
		//注册时间，并作为用户密码md5加密的salt
		String reg_date = DateUtils.getNowTime();
		
		//使用jfinal标识生成工具生成随机数作为密码的盐
		
		String pwd = MD5.GetMD5Code(getPara("user.pwd")+reg_date);
		
		
		user.setRegDate(reg_date);
		user.setPwd(pwd);
		user.setStatus(0);
		user.save();
		
		//生成唯一标识
		String sessionId = SessionIdKit.me().generate(getRequest());
		//设置服务器端session
		setSessionAttr(sessionId, user);
		//设置用户端cookie
		setCookie("cuser", sessionId, 600);
		
		setAttr("user", user);
		redirect("/user");
		}
	}
	
	
}
