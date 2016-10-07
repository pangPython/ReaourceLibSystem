package com.huijiasoft.test;

import com.huijiasoft.utils.DateUtils;

public class DateTest {
	public static void main(String[] args) {
		System.out.println(DateUtils.dateToUnixTimestamp(DateUtils.getNowTime()));
		//System.out.println(DateUtils.getNowTime(/type)+" ");
	}
}
