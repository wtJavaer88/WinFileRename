package com.batch.test;

import com.batch.ren.AbstractWinFileRen;
import com.batch.ren.WinFileNameReplace;

public class testRep {
	public static void main(String[] args) {
		System.out.println("ddd".substring(3));
		// 测试正则表达式的删除
		AbstractWinFileRen fileRen = new WinFileNameReplace().openEnableExp().setReplaceStr("\\d+");
		String folder = "E:\\BaiduYunDownload\\第六季\\新建文件夹";
		String menuTxt = "E:\\BaiduYunDownload\\第六季\\新建文件夹\\menu.txt";
		fileRen.ren(folder);
		// 测试越界的替换
		AbstractWinFileRen fileRen2 = new WinFileNameReplace().openEnableExp().setReplaceStr("AAA").setSelectStart(24)
				.setSelectCount(4);
		fileRen2.ren(folder);
		// 测试越界(负数)的替换
		fileRen2 = new WinFileNameReplace().openEnableExp().setReplaceStr("AAA").setSelectStart(-1).setSelectCount(-1);
		fileRen2.ren(folder);
		// 测试临界的删除
		fileRen2 = new WinFileNameReplace().openEnableExp().setReplaceStr("AAA").setSelectStart(7).setSelectCount(1);
		fileRen2.ren(folder);

		// 测试从一个txt菜单中取文件来替换
		fileRen2.ren(menuTxt);

	}
}
