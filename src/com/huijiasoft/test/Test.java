package com.huijiasoft.test;

import com.huijiasoft.utils.JavaMysqlUtil;

public class Test {
	public static void main(String[] args) {
//		PropKit.use("myconfig.txt");
//		System.out.println(PropKit.get("jdbcUrl"));
		
		JavaMysqlUtil.backup("1.sql");
		
	}
}
