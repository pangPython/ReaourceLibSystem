package com.huijiasoft.utils;

import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

import com.huijiasoft.model.User;

/**
 * @author pangPython
 *	数据库工具类
 */
public class DBUtils {
	
	
	
	//判断数据库某条记录的属性字段是否包含空值
	public static Boolean RecordAttrHasNull(User user){
		Set<Entry<String, Object>> set = user._getAttrsEntrySet();
		
		Iterator<Entry<String, Object>> it = set.iterator();
		
		while(it.hasNext()){
			Entry<String, Object> attr = it.next();
			if(attr.getValue()==null){
				return true;
			}
			
		}
		return false;
	}
	
	
	
}
