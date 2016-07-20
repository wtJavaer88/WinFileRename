package com.batch.valid;

import java.io.File;
import java.util.Arrays;

public class FileNameExtendValitor implements Valitor {
	@Override
	public String toString() {
		return "文件扩展(FileNameExtendValitor) [keys=" + Arrays.toString(keys) + ", ignoreCase=" + ignoreCase + "]";
	}

	private String[] keys;
	private boolean ignoreCase = true;

	public FileNameExtendValitor setIgnoreCase(boolean ignoreCase) {
		this.ignoreCase = ignoreCase;
		return this;
	}

	/**
	 * 默认忽略大小写,对于指定的扩展名,符合其中一个就行
	 * 
	 * @param args
	 */
	public FileNameExtendValitor(String... args) {
		if (args == null || args.length == 0) {
			throw new IllegalArgumentException("FileNameExtendValitor至少需要一个参数!");
		}
		this.keys = args;
	}

	@Override
	public boolean valid(File file) {
		for (String key : keys) {
			String name = file.getName();
			if (ignoreCase) {
				name = name.toUpperCase();
				key = key.toUpperCase();
			}

			if (name.endsWith(key)) {
				return true;
			}
		}
		return false;
	}

}
