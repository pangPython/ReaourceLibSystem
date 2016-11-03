package com.huijiasoft.model;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huijiasoft.model.base.BaseUser;
import com.huijiasoft.utils.SQLUtils;
import com.jfinal.plugin.activerecord.Page;

@SuppressWarnings("serial")
public class User extends BaseUser<User> {
	
	public static final User usermodel = new User();
	
	
	//Jfinal提供分页
	public Page<User> paginate(int pageNumber,int pageSize){
		
		return paginate(pageNumber, pageSize, "select *", "from user order by id asc");
	}
	
	//未使用Jfinal分页，使用h-ui-admin提供的js分页
	public List<User> getAllUser(){
		String sql = "select u.*,d.decname,m.mzname,z.zzmmname,a.area_name from ((((user u left join declare_type d on u.dec_id = d.dec_id) left join mz m on u.mz_id = m.mz_id) left join zzmm z on u.zzmm_id = z.zzmm_id) left join area a on u.area_id = a.area_id) order by u.status desc,reg_date asc";
		return  usermodel.find(sql);
	}
	
	
	//获取某个用户管理表
	public User findById_Relation(int id){
		String sql = "select u.*,d.decname,m.mzname,z.zzmmname from (((user u left join declare_type d on u.dec_id = d.dec_id) left join mz m on u.mz_id = m.mz_id) left join zzmm z on u.zzmm_id = z.zzmm_id) where u.id = ?";
		return usermodel.findFirst(sql,id);
	}
	
	public List<User> getUserByAreaId(int area_id){
		String sql = "select u.*,d.decname,m.mzname,z.zzmmname from (((user u left join declare_type d on u.dec_id = d.dec_id) left join mz m on u.mz_id = m.mz_id) left join zzmm z on u.zzmm_id = z.zzmm_id) where area_id = ?";
		return usermodel.find(sql,area_id);
	}
	
	//条件查询用户列表
	public List<User> getUserListByCondition(Map<String,Object> map){
		String sql = "select p.*,d.decname,m.mzname,z.zzmmname,a.area_name from ((((user p left join declare_type d on p.dec_id = d.dec_id) left join mz m on p.mz_id = m.mz_id) left join zzmm z on p.zzmm_id = z.zzmm_id) left join area a on p.area_id = a.area_id) "+SQLUtils.DynamicSQL(map);
		return usermodel.find(sql);
	}
	
	public Map<String,String> getEduDegreeSchool(User user){
		Map<String,String> map = new HashMap<String, String>();
		String full_time = "";
		String part_time = "";
		String full_time_school = "";
		String part_time_school = "";
		
		int f = 0;
		Long df ;
		if(user.getEduFullTime() != null){
			f = user.getEduFullTime();
			switch (f) {
			case 0:
				part_time += Edu.dao.getEduNameById(f);
				part_time_school += user.getEduSchool();
				break;
			case 1:
				full_time += Edu.dao.getEduNameById(f);
				full_time_school += user.getEduSchool();
				break;
				
			default:
				break;
			}
		}
		if(user.getDegreeFullTime()!=null){
			df = user.getDegreeFullTime();
			switch (df.intValue()) {
			case 0:
				part_time += Degree.dao.getDegreeNameById(df);
				part_time_school += user.getDegreeSchool();
				break;
			case 1:
				full_time += Degree.dao.getDegreeNameById(df);
				full_time_school += user.getDegreeSchool();
				break;
			default:
				break;
			}
		}
		
		map.put("part_time", part_time);
		map.put("full_time", full_time);
		map.put("part_time_school", part_time_school);
		map.put("full_time_school", full_time_school);
		
		
		return map;
	}

	public boolean UnameIsExists(String uname){
		if(usermodel.findFirst("select * from user where uname = ? limit 1", uname)!=null){
			return true;
		}
		return false;
	}
	
	
	public boolean UserIsChecked(int user_id){
		User user = usermodel.findById(user_id);
		if(user.getStatus()==1){
			return true;
		}
		return false;
	}

}
