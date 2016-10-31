package com.huijiasoft.model;

import java.util.List;

import com.huijiasoft.model.base.BaseArea;
import com.jfinal.plugin.activerecord.Page;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class Area extends BaseArea<Area> {
	public static final Area dao = new Area();
	
	public Page<Area> paginate(int pageNumber,int pageSize){
		return paginate(pageNumber,pageSize,"select *","from area order by area_id asc");
	}
	
	
	public List<Area> getAllArea(){
		return dao.find("select * from area order by area_id asc");
	}
	
	public String getAreaNameById(String id){
		String area = "��ʱ�޷���ʾ";
		try {
			area = dao.findById(id).getAreaName();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return area;
	}
}
