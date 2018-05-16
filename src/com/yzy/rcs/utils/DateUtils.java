package com.yzy.rcs.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DateUtils {
	public static String getFormatDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return sdf.format(new Date());
	}
	
	public static String randomId(){
		return new SimpleDateFormat("yyyyMMdd_hhmmss_").format(new Date())+new Random().nextInt(9000)+1000;
	}
}
