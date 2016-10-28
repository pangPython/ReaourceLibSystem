package com.huijiasoft.model;

import java.util.List;

import com.huijiasoft.model.base.BaseDegree;
import com.jfinal.plugin.activerecord.Page;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class Degree extends BaseDegree<Degree> {
	public static final Degree dao = new Degree();
	
	public Page<Degree> paginate(int pageNumber,int pageSize){
		return paginate(pageNumber,pageSize,"select *","from degree order by degree_id asc");
	}
	
	
	public List<Degree> getAllDegree(){
		return dao.find("select * from degree order by degree_id asc");
	}
	
	public String getDegreeNameById(long id){
		return dao.findById(id).getDegreename();
	}
}
