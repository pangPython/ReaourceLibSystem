package com.huijiasoft.model;

import javax.sql.DataSource;

import com.huijiasoft.config.MyConfig;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.generator.Generator;
import com.jfinal.plugin.c3p0.C3p0Plugin;

public class _JFinalGenerator {
	public static DataSource getDataSource(){
		PropKit.use("myconfig.txt");
		C3p0Plugin c3p0Plugin = MyConfig.createC3p0Plugin();
		c3p0Plugin.start();
		return c3p0Plugin.getDataSource();
	}
	
/*	public static void main(String[] args) {
		String baseModelPackageName = "com.huijiasoft.model.base";
		
		String baseModelOutputDir = PathKit.getWebRootPath()+"/../src/com/huijiasoft/model/base";
		
		String modelPackage = "com.huijiasoft.model";
		
		String modelOutputDir = baseModelOutputDir+"/..";
		
		Generator generator = new Generator(getDataSource(), baseModelPackageName,baseModelOutputDir,modelPackage,modelOutputDir);
		// 添加不需要生成的表名
		//generator.addExcludedTable("adv");
		// 设置是否在 Model 中生成 dao 对象
		generator.setGenerateDaoInModel(true);
		// 设置是否生成字典文件
		generator.setGenerateDataDictionary(false);
		// 设置需要被移除的表名前缀用于生成modelName。例如表名 "osc_user"，移除前缀 "osc_"后生成的model名为 "User"而非 OscUser
		//generator.setRemovedTableNamePrefixes("t_");
		// 生成
		generator.generate();
		
		
	}
*/	
}
