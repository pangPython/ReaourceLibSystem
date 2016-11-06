package com.huijiasoft.utils;

import java.io.File;
import java.util.ArrayList;

/**
 * @author pangPython
 *	路径工具类
 */
public class PathUtils {
	
	private static ArrayList<String> file_path_list = new ArrayList<String>();
	
	//如果路径不存在就创建
	public static boolean createNotExist(String path){
		File file = new File(path);
		if(!file.exists()){
			if(file.mkdir()){
				return true;
			}
			return false;
		}
		return true;
	}
	
	//遍历文件夹中的所有文件
	public static ArrayList<String> getAllFilePath(String path){
		
		file_path_list.clear();
		
		File root = new File(path);
		File[] files = root.listFiles();

		if(files==null){
			return null;
		}
		
		for(File file:files){
			if(file.isDirectory()){
				getAllFilePath(file.getAbsolutePath());
				//System.out.println("子目录及其文件  "+file.getName());
			}
			//System.out.println("zimulu "+file.getName());
			file_path_list.add(file.getName());
			
		}
		
		return file_path_list;
	}
	
	
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //递归删除目录中的子目录下
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }
}
