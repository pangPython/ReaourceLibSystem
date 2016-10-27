package com.huijiasoft.utils;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author pangPython
 *	sql工具类
 */
public class SQLUtils {

	//根据请求参数动态生成sql，过滤空值
	//适用于条件查询
	public static String DynamicSQL(Map<String,Object> map){
		
		String sql = " where ";
		
		//遍历map把其中value为空的删除
		Iterator it = map.entrySet().iterator();
		
		while(it.hasNext()){
			Map.Entry mapentry = (Entry) it.next();
			if(mapentry.getValue()!=null){
				sql = sql + mapentry.getKey() + " = " + mapentry.getValue()+" and ";
			}
			
		}
		

		System.out.println(sql+" ---------拼装的SQL---------");
		
		if(sql.trim().endsWith("and")){
			sql = sql.substring(0, sql.lastIndexOf("and"));
		}
		
		sql = sql.replaceAll("user", "u");
		
		System.out.println(sql+" ---------拼装的SQL---------");
		//剩下的组装成sql
		return sql;
	}
}
