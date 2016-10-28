package com.huijiasoft.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.huijiasoft.model.Area;
import com.huijiasoft.model.DeclareType;
import com.huijiasoft.model.Degree;
import com.huijiasoft.model.Edu;
import com.huijiasoft.model.Mz;
import com.huijiasoft.model.User;
import com.huijiasoft.model.Zzmm;

/**
 * @author pangPython 后台报表
 */
public class ReportExcel {
	public static String report(List<User> userlist) throws IOException, ParseException {
		Workbook wb = new HSSFWorkbook();
		// Workbook wb = new XSSFWorkbook();
		CreationHelper createHelper = wb.getCreationHelper();
		Sheet sheet = wb.createSheet("new sheet");

		// Create a row and put some cells in it. Rows are 0 based.
		Row row = sheet.createRow((short) 0);
		// Create a cell and put a value in it.
		Cell cell = row.createCell(0);
		cell.setCellValue(createHelper.createRichTextString("姓名"));
		row.createCell(1).setCellValue(createHelper.createRichTextString("性别"));
		row.createCell(2).setCellValue(createHelper.createRichTextString("出生年月"));
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

		int user_age = 20;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		for (int i = 0; i < userlist.size(); i++) {
			Row data = sheet.createRow((short) i + 1);
			User user = userlist.get(i);

			// DBUtils.setEmptyIfNull(user);
			String tn = user.getTrueName();
			String us = user.getUsersex();
			String birth = user.getBirth();
			Long mz = user.getMzId();
			Long zzmm = user.getZzmmId();

			Long dec_id = user.getDecId();
			String card = user.getCard();
			Long degree_id = user.getDegreeId();
			Long edu_id = user.getEduId();
			String area_id = user.getAreaId();
			String address = user.getAddress();
			String tel = user.getTelephone();
			String company = user.getCompany();
			String com_tel = user.getCompanyTel();
			String health = user.getHealth();
			String spt = user.getSocioPartTime();
			String ysjj = user.getYsjj();
			String ba = user.getBusinessAchievement();
			String aws = user.getAwards();
			String op = user.getOpinion();

			if (tn == null) {
				data.createCell(0).setCellValue("");
			} else {
				data.createCell(0).setCellValue(tn);
			}
			if (us == null) {
				data.createCell(1).setCellValue("");
			} else {
				if ("0".equals(us)) {
					data.createCell(1).setCellValue("女");
				} else {
					data.createCell(1).setCellValue("男");
				}
			}
			if (birth == null) {
				data.createCell(2).setCellValue("");
			} else {
				data.createCell(2).setCellValue(birth);
			}
			if (mz == null) {
				data.createCell(3).setCellValue("");
			} else {
				String nation = Mz.dao.getMzNameById(mz);
				data.createCell(3).setCellValue(nation);
			}
			if (zzmm == null) {
				data.createCell(4).setCellValue("");
			} else {
				String zzmmname = Zzmm.dao.getZzmmNameById(zzmm);
				data.createCell(4).setCellValue(zzmmname);
			}
			if (dec_id == null) {
				data.createCell(5).setCellValue("");
			} else {
				String decname = DeclareType.dao.getDecNameById(dec_id);
				data.createCell(5).setCellValue(decname);
			}
			if (card == null) {
				data.createCell(6).setCellValue("");
			} else {
				data.createCell(6).setCellValue(card);
			}
			if (degree_id == null) {
				data.createCell(7).setCellValue("");
			} else {
				String degree = Degree.dao.getDegreeNameById(degree_id);
				data.createCell(7).setCellValue(degree);
			}
			if (edu_id == null) {
				data.createCell(8).setCellValue("");
			} else {
				String edu = Edu.dao.getEduNameById(edu_id);
				data.createCell(8).setCellValue(edu);
			}
			if (area_id == null) {
				data.createCell(9).setCellValue("");
			} else {
				String area = Area.dao.getAreaNameById(area_id);
				data.createCell(9).setCellValue(area);
			}
			if (address == null) {
				data.createCell(10).setCellValue("");
			} else {
				data.createCell(10).setCellValue(address);
			}
			if (tel == null) {
				data.createCell(11).setCellValue("");
			} else {
				data.createCell(11).setCellValue(tel);
			}
			if (company == null) {
				data.createCell(12).setCellValue("");
			} else {
				data.createCell(12).setCellValue(company);
			}
			if (com_tel == null) {
				data.createCell(13).setCellValue("");
			} else {
				data.createCell(12).setCellValue(com_tel);
			}
			if (health == null) {
				data.createCell(14).setCellValue("");
			} else {
				data.createCell(14).setCellValue(user.getHealth());
			}
			if (spt == null) {
				data.createCell(15).setCellValue("");
			} else {
				data.createCell(15).setCellValue(spt);
			}
			if (ysjj == null) {
				data.createCell(16).setCellValue("");
			} else {
				data.createCell(16).setCellValue(ysjj);
			}
			if (ba == null) {
				data.createCell(17).setCellValue("");
			} else {
				data.createCell(17).setCellValue(ba);
			}
			if (aws == null) {
				data.createCell(18).setCellValue("");
			} else {
				data.createCell(18).setCellValue(aws);
			}
			if (op == null) {
				data.createCell(19).setCellValue("");
			} else {
				data.createCell(19).setCellValue(op);
			}

		}

		String filename = DateUtils.dateToUnixTimestamp(DateUtils.getNowTime()) + ".xls";
		String path = "WebRoot\\download\\report\\" + filename;
		FileOutputStream fileOut = new FileOutputStream(path);

		try {

			wb.write(fileOut);
			fileOut.close();

		} catch (Exception e) {
			e.printStackTrace();
		}


		return path;
	}
}
