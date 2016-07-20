package com.batch;

import java.util.HashMap;
import java.util.Map;

import com.batch.util.FileNameUtil;

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
	 * @return
	 */
	public synchronized static String pushAndGetValidTarget(String target, String extendName) {
		if (!targetRepeatTimesMap.containsKey(target)) {
			// 初始重复值为1,表示该文件名独一无二
			targetRepeatTimesMap.put(target, 1);
		} else {
			// 如果已经有了,则必然重复,重复值+1
			int count = targetRepeatTimesMap.get(target);
			targetRepeatTimesMap.remove(target);
			targetRepeatTimesMap.put(target, count + 1);
		}
		return getValidTarget(target, extendName);
	}

	private static String getValidTarget(String target, String extendName) {
		Integer integer = targetRepeatTimesMap.get(target);
		if (integer > 1) {
			// System.out.println("target重复:" + target + " "
			// + FileNameUtil.getFileNameNoExtend(target));
			target = String.format(FileNameUtil.getFileNameNoExtend(target) + conflictStr + extendName, integer);
		}
		return target;
	}
}
