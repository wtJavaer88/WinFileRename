package com.batch.valid;

import java.io.File;

public class FileOrFolderModelValitor implements Valitor {
	@Override
	public String toString() {
		return "文件或文件夹匹配(FileOrFolderModelValitor) [dealFile=" + dealFile + ", dealFolder=" + dealFolder + "]";
	}

	private boolean dealFile = true;
	private boolean dealFolder = true;

	/**
	 * 指定操作文件或文件夹
	 * 
	 * @param dealFile
	 * @param dealFolder
	 */
	public FileOrFolderModelValitor(boolean dealFile, boolean dealFolder) {
		this.dealFile = dealFile;
		this.dealFolder = dealFolder;
	}

	@Override
	public boolean valid(File file) {
		if (file.isFile() && dealFile) {
			return true;
		}
		if (file.isDirectory() && dealFolder) {
			return true;
		}
		return false;
	}
}
