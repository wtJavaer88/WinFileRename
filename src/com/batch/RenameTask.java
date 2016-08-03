package com.batch;

import java.io.File;

import com.batch.ren.AbstractWinFileRen;
import com.batch.util.FileNameUtil;
import com.batch.util.Logger;
import com.wnc.basic.BasicFileUtil;

public class RenameTask implements Runnable {

	File file;
	AbstractWinFileRen abstractWinFileRen;

	public RenameTask(AbstractWinFileRen abstractWinFileRen, File file) {
		this.abstractWinFileRen = abstractWinFileRen;
		this.file = file;
	}

	@Override
	public void run() {
		String absolutePath = file.getAbsolutePath();
		String folder = FileNameUtil.getFolder(absolutePath);
		String fileName = FileNameUtil.getFileNameNoExtend(absolutePath);
		String extendName = FileNameUtil.getFileExtend(absolutePath);

		String target = abstractWinFileRen.renOneFile(fileName, extendName);
		if (target != null) {
			target = ProductQueue.pushAndGetValidTarget(target, extendName);
			String targetPath = BasicFileUtil.getMakeFilePath(folder, target);
			Logger.log("改名前:" + absolutePath + "\t\t改名后:" + targetPath);

			if (!AbstractWinFileRen.isTestModel())
				BasicFileUtil.renameFile(absolutePath, targetPath);
			abstractWinFileRen.putNewPair(targetPath, absolutePath);
		}
	}

}
