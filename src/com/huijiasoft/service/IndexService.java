package com.huijiasoft.service;

import com.huijiasoft.model.System;

public class IndexService {
	public static System getSysConfig(){
		return System.dao.findFirst("select * from system limit 1");
	}
	//检测系统配置中站点开放参数
	public static boolean siteIsOpen(){
		return "1".equals(getSysConfig().getOpen());
	}
	
}
