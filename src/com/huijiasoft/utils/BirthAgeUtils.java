package com.huijiasoft.utils;

import java.util.Date;

/**
 * @author pangPython
 *	出生年月 年龄 工具类
 */
public class BirthAgeUtils {

	//根据年龄获取生日 返回字符串型
	public static String getBirthByAge(String age){
		int now = Integer.parseInt(DateUtils.getNowTime("yyyy"));
		int a = Integer.parseInt(age);
		return (now - a)+"";
	}
	
	//根据年龄获取生日 返回日期型
	public static Date getBirthByAge(int age){
		int now = Integer.parseInt(DateUtils.getNowTime("yyyy"));
		int birth = now - age;
		
		return null;
	}
}
