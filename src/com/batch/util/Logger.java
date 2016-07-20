package com.batch.util;

import java.util.Map;

import com.batch.ren.AbstractWinFileRen;
import com.wnc.basic.BasicDateUtil;
import com.wnc.basic.BasicFileUtil;

public class Logger {
	private static final String logDir = "D:\\log\\rename\\";

	/**
	 * 测试模式不记录日志, 只输出Console
	 * 
	 * @param msg
	 */
	public static void log(String msg) {

		if (!BasicFileUtil.isExistFolder(logDir)) {
			throw new RuntimeException("日志文件夹不存在!");
		}

		// System.out.println(msg);
		if (!AbstractWinFileRen.isTestModel())
			BasicFileUtil.writeFileString(logDir + "renlog" + BasicDateUtil.getCurrentDateString() + ".txt",
					msg + "\r\n", null, true);
		else {
			System.out.println(msg);
		}
	}

	public static void logErr(String msg) {
		if (!BasicFileUtil.isExistFolder("D:\\log\\rename\\")) {
			throw new RuntimeException("日志文件夹不存在!");
		}
		System.err.println(msg);
		BasicFileUtil.writeFileString(logDir + "renErrlog" + BasicDateUtil.getCurrentDateString() + ".txt",
				msg.replace(",", "\r\n") + "\r\n", null, true);

	}

	public static void serialize(Map<String, String> renMap) {
		if (!AbstractWinFileRen.isTestModel() && renMap != null && renMap.size() > 0)
			SerializableUtil.serializableObject(logDir, renMap);
	}
}
