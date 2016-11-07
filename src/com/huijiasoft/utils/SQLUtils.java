package com.huijiasoft.utils;

import java.text.ParseException;
import java.util.Date;
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
	public static String DynamicSQL(Map<String,Object> map) throws ParseException{
		
		String end = null;
		String start = null;
		String dec = "";
		
		try {
			int minage = (Integer) map.get("minage");
			int maxage = (Integer) map.get("maxage");
			
			start = BirthAgeUtils.getMinBirthByAge(minage);
			end = BirthAgeUtils.getMaxBirthByAge(maxage);
		
			
			
		} catch (Exception e) {
			
			// TODO: handle exception
		}
		
		try {
			String[] decs =  (String[]) map.get("dec_id");
			
			for (int i = 0; i < decs.length; i++) {
				dec += decs[i]+",";
			}
			System.out.println(dec+"=====");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		map.remove("dec_id");
		map.remove("minage");
		map.remove("maxage");
		
		//map.replace("dec_id", null);
		
		
		String sql = " where ";
		
		//遍历map把其中value为空的删除
		Iterator it = map.entrySet().iterator();
		
		while(it.hasNext()){
			Map.Entry mapentry = (Entry) it.next();
			if(mapentry.getValue()!=null){
				sql = sql + mapentry.getKey() + " = " + mapentry.getValue()+" and ";
			}
			
		}
		if(start!=null && end!=null){
			if(sql.trim().endsWith("where") || sql.trim().endsWith("and")){
				sql = sql + " p.birth > '" + end + "' and p.birth < '"+start+"'";
			}else{
				
				sql = sql + " and p.birth > '" + end + "' and p.birth < '"+start+"'";
			}
		}
		
		if (dec != null && dec != "") {
			if (dec.trim().endsWith(",")) {
				dec = dec.substring(0, dec.lastIndexOf(","));
			}
			dec = "(" + dec + ")";

			if (sql.trim().endsWith("where") || sql.trim().endsWith("and")) {
				sql = sql + " p.dec_id in " + dec;
			} else {
				sql = sql + " and p.dec_id in " + dec;
			}

		}
		
		if(sql.trim().endsWith("and")){
			sql = sql.substring(0, sql.lastIndexOf("and"));
		}
		
		
		if(sql.equals(" where ")){
			
			return "";
		}
		
		//因为用到表的别名，需要替换
//		sql = sql.replaceAll("user.usersex", "u.usersex");
//		sql = sql.replaceAll("user.", "u.");
		
		System.out.println(sql);
		
		return sql;
	}
}
