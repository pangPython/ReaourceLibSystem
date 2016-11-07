package com.huijiasoft.test;

import java.text.ParseException;

import com.huijiasoft.utils.BirthAgeUtils;
import com.huijiasoft.utils.PhotoUtils;
import com.jfinal.kit.PathKit;

public class tt {
	public static void main(String[] args) throws ParseException {
//		System.out.println(BirthAgeUtils.getBirthByAge("22"));
	//	System.out.println(DateUtils.dateToUnixTimestamp(DateUtils.getNowTime(), "yyyy-MM-dd"));
		//System.out.println(BirthAgeUtils.getMinBirthByAge(22));
	
		System.out.println(PhotoUtils.getImageStr(PathKit.getWebRootPath()+"\\upload\\1.jpg"));
	
	}
	
	
}
