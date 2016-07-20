package com.batch.test;

import java.io.IOException;

import com.batch.ren.AbstractWinFileRen;
import com.batch.ren.WinFileNameExtend;

public class CopyOftestExtend {
	public static void main(String[] args) throws IOException {
		AbstractWinFileRen fileRen = new WinFileNameExtend().setExtendName("jpg");
		String folder = "E:\\BaiduYunDownload\\第六季\\新建文件夹";
		fileRen.ren(folder);
	}
}
