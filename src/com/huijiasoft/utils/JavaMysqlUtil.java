package com.huijiasoft.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.jfinal.kit.PropKit;

public class JavaMysqlUtil {

	 /**
     * 
     * mysql数据备份 接收脚本名，并返回此路径
     * 
     * sql为备份的脚本名比如xxx.sql
     * 
     */
    //备份数据库
    public static String backup(String sql) {
    
    	Properties pros = getPprVue("prop.properties");
     // 这里是读取的属性文件，也可以直接使用
    
     String username = pros.getProperty("username");
    
     String password = pros.getProperty("password");
    
     // 得到MYSQL的用户名密码后调用 mysql 的 cmd:
     
     String mysqlpaths = pros.getProperty("mysqlpath");
     //String mysqlpaths = "D:\\phpStudy\\MySQL\\bin\\";
     String databaseName = pros.getProperty("databaseName");
     String address = pros.getProperty("address");
     String sqlpath = pros.getProperty("sql");
     
     
     File backupath = new File(sqlpath);
     
     if (!backupath.exists()) {
      backupath.mkdir();
     }
    
     StringBuffer sb = new StringBuffer();
    
     sb.append(mysqlpaths);
     sb.append("mysqldump ");
     sb.append("--opt ");
     sb.append("-h ");
     sb.append(address);
     sb.append(" ");
     sb.append("--user=");
     sb.append(username);
     sb.append(" ");
     sb.append("--password=");
     sb.append(password);
     sb.append(" ");
     sb.append("--lock-all-tables=true ");
     sb.append("--result-file=");
     sb.append(sqlpath);
     sb.append(sql);
     sb.append(" ");
     sb.append("--default-character-set=utf8 ");
     sb.append(databaseName);
     Runtime cmd = Runtime.getRuntime();
     try {
      Process p = cmd.exec(sb.toString());
     } catch (IOException e) {
      e.printStackTrace();
     }
     	System.out.println(sqlpath+sql+"   file path name ");
     return sqlpath+sql;
     
    }
    
    // 读取属性值
    
    public static Properties getPprVue(String properName) {
    
     InputStream inputStream = JavaMysqlUtil.class.getClassLoader().getResourceAsStream(properName);
     Properties p = new Properties();
    
     try {
      p.load(inputStream);
      inputStream.close();
     } catch (IOException e) {
      e.printStackTrace();
     }
    
     return p;
    
    }
    //还原备份
    public static void load(String filename) {
     Properties pros = getPprVue("prop.properties");
    
     // 这里是读取的属性文件，也可以直接使用
    
     String root = PropKit.get("jdbc.username");
    
     String pass = PropKit.get("jdbc.password");
    
     // 得到MYSQL的用户名密码后调用 mysql 的 cmd:
    
     String mysqlpaths = PropKit.get("mysqlpath");
     String sqlpath = PropKit.get("sql");
     String filepath = mysqlpaths + sqlpath + filename; // 备份的路径地址
    
     // 新建数据库finacing
     String stmt1 =mysqlpaths+ "mysqladmin -u " + root + " -p" + pass + " create finacing"; // -p后面加的是你的密码
     String stmt2 = mysqlpaths+"mysql -u " + root + " -p" + pass + " finacing < "+ filepath;
     String[] cmd = { "cmd", "/c", stmt2 };
     try {
      Runtime.getRuntime().exec(stmt1);
      Runtime.getRuntime().exec(cmd);
      System.out.println("数据已从 " + filepath + " 导入到数据库中");
     } catch (IOException e) {
      e.printStackTrace();
     }
    
    }

}
