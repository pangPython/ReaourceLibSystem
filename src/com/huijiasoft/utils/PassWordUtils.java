package com.huijiasoft.utils;


/**
 * @author pangPython
 *	有关密码工具类
 */
public class PassWordUtils {
	public static String MD5withSalt(String pwd,String salt){
		return MD5.GetMD5Code(pwd+salt);
	}
}
