package edu.song.elasticsearch.client;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
/**
 * @author stab  2015年 04月 22日 星期三
 */
public class TimeParser {
	
	public static String timestampToDate(long timeLong){
		SimpleDateFormat df = new SimpleDateFormat("MM-dd HH:mm:ss");//定义格式，不显示毫秒
		//long timeLong = Long.parseLong(timestamp);
		//timeLong-=28800000;
		Timestamp timestamp = new Timestamp(timeLong);//获取系统当前时间
		String dateString = df.format(timestamp);
		return dateString;
	}
	
	/*public static String dateToTimestamp(String timeString) {
		SimpleDateFormat df = new SimpleDateFormat("MM-dd HH:mm:ss");//定义格式，不显示毫秒
		long timeLong = Long.parseLong(timeString);
		timeLong-=28800000;
		Timestamp timestamp = new Timestamp(timeLong);//获取系统当前时间
		String dateString = df.format(timestamp);
		return dateString;
	}*/
}
