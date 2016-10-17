package com.huijiasoft.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.huijiasoft.model.User;

/**
 * @author pangPython
 *		后台报表
 */
public class ReportExcel {
	public static String report(List<User> userlist) throws IOException{
		 Workbook wb = new HSSFWorkbook();
		    //Workbook wb = new XSSFWorkbook();
		    CreationHelper createHelper = wb.getCreationHelper();
		    Sheet sheet = wb.createSheet("new sheet");

		    // Create a row and put some cells in it. Rows are 0 based.
		    Row row = sheet.createRow((short)0);
		    // Create a cell and put a value in it.
		    Cell cell = row.createCell(0);
		    cell.setCellValue(createHelper.createRichTextString("姓名"));
		    row.createCell(1).setCellValue(createHelper.createRichTextString("性别"));
		    row.createCell(2).setCellValue(createHelper.createRichTextString("年龄"));
		    row.createCell(3).setCellValue(createHelper.createRichTextString("民族"));
		    row.createCell(4).setCellValue(createHelper.createRichTextString("政治面貌"));
		    row.createCell(5).setCellValue(createHelper.createRichTextString("申报类别"));
		    row.createCell(6).setCellValue(createHelper.createRichTextString("身份证号"));
		    row.createCell(7).setCellValue(createHelper.createRichTextString("学位"));
		    row.createCell(8).setCellValue(createHelper.createRichTextString("学历"));
		    row.createCell(9).setCellValue(createHelper.createRichTextString("所在地区"));
		    row.createCell(10).setCellValue(createHelper.createRichTextString("家庭住址"));
		    row.createCell(11).setCellValue(createHelper.createRichTextString("手机号"));
		    row.createCell(12).setCellValue(createHelper.createRichTextString("所在单位"));
		    row.createCell(13).setCellValue(createHelper.createRichTextString("单位电话"));
		    row.createCell(14).setCellValue(createHelper.createRichTextString("健康状况"));
		    row.createCell(15).setCellValue(createHelper.createRichTextString("重要社会兼职"));
		    row.createCell(16).setCellValue(createHelper.createRichTextString("主要工作及艺术简历"));
		    row.createCell(17).setCellValue(createHelper.createRichTextString("主要业务成就"));
		    row.createCell(18).setCellValue(createHelper.createRichTextString("获奖情况"));
		    row.createCell(19).setCellValue(createHelper.createRichTextString("本人申请意见"));
		    
		    for(int i=0;i<userlist.size();i++){
		    	 Row data = sheet.createRow((short)i+1);
		    	 User user = userlist.get(i);
		    	 data.createCell(0).setCellValue(user.getTrueName());
		    	 data.createCell(1).setCellValue(user.getUsersex());
		    	 data.createCell(2).setCellValue(user.getAge());
		    	 data.createCell(3).setCellValue(user.getMzId());
		    	 data.createCell(4).setCellValue(user.getZzmmId());
		    	 data.createCell(5).setCellValue(user.getDecId());
		    	 data.createCell(6).setCellValue(user.getCard());
		    	 data.createCell(7).setCellValue(user.getDegreeId());
		    	 data.createCell(8).setCellValue(user.getEduId());
		    	 data.createCell(9).setCellValue(user.getAreaId());
		    	 data.createCell(10).setCellValue(user.getAddress());
		    	 data.createCell(11).setCellValue(user.getTelephone());
		    	 data.createCell(12).setCellValue(user.getCompany());
		    	 data.createCell(13).setCellValue(user.getCompanyTel());
		    	 data.createCell(14).setCellValue(user.getHealth());
		    	 data.createCell(15).setCellValue(user.getSocioPartTime());
		    	 data.createCell(16).setCellValue(user.getYsjj());
		    	 data.createCell(17).setCellValue(user.getBusinessAchievement());
		    	 data.createCell(18).setCellValue(user.getAwards());
		    	 data.createCell(19).setCellValue(user.getOpinion());
		    }
		    
		    String filename = DateUtils.dateToUnixTimestamp(DateUtils.getNowTime())+".xls";
		    String path = "WebRoot\\download\\report\\"+filename;
		    FileOutputStream fileOut = new FileOutputStream(path);
	
		    try {
		    	
		    	wb.write(fileOut);
				fileOut.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		    
		    System.out.println(path+"  Excel path");
		    
		    return path;
	}
}
