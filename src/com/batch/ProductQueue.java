package com.batch;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.batch.util.FileNameUtil;
import com.wnc.basic.BasicFileUtil;

/**
 * 记录每次改名后的文件名,以及他们出现的次数,好对重复文件重命名
 * 
 * @author cpr216
 * 
 */
public class ProductQueue {

	private static Map<String, Integer> targetRepeatTimesMap = new HashMap<String, Integer>();
	private static String conflictStr = "(%d)";

	public static void clear() {
		targetRepeatTimesMap.clear();
	}

	/**
	 * 写入队列,检查是否重复,获取文件名
	 * 
	 * @param target
	 * @param extendName
	 * @param extendName2
	 * @return
	 */
	public synchronized static String pushAndGetValidTarget(String folder, String target, boolean isFolder) {
		String path = folder + File.separator + target;
		if (!targetRepeatTimesMap.containsKey(path)) {
			// 初始重复值为1,表示该文件名独一无二
			targetRepeatTimesMap.put(path, 1);
		} else {
			// 如果已经有了,则必然重复,重复值+1
			int count = targetRepeatTimesMap.get(path);
			targetRepeatTimesMap.remove(path);
			targetRepeatTimesMap.put(path, count + 1);
		}
		return getValidTarget(path, target, isFolder);
	}

	private static String getValidTarget(String path, String target, boolean isFolder) {
		Integer integer = targetRepeatTimesMap.get(path);
		String ret = target;
		if (integer > 1) {
			// System.out.println("target重复:" + target + " "
			// + FileNameUtil.getFileNameNoExtend(target));
			if (isFolder) {
				ret = String.format(target + conflictStr, integer);
			} else
				ret = String.format(
						FileNameUtil.getFileNameNoExtend(path) + conflictStr + BasicFileUtil.getFileType(path),
						integer);
		}
		return ret;
	}
}
