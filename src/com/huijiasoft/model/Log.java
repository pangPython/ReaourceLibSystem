package com.huijiasoft.model;

import java.util.List;

import com.huijiasoft.model.base.BaseLog;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class Log extends BaseLog<Log> {
	public static final Log dao = new Log();
	
	public List<Log> getAllLog(){
		String sql = "select * from log";
		return dao.find(sql);
	}
}
