package com.batch.test;

import com.batch.ren.AbstractWinFileRen;
import com.batch.ren.WinFileNameDelete;

public class testDel {
	public static void main(String[] args) {
		System.out.println("ddd".substring(3));
		// 测试正则表达式的删除
		AbstractWinFileRen fileRen = new WinFileNameDelete().openEnableExp().setDeleteStr("\\d+");
		String folder = "E:\\BaiduYunDownload\\第六季\\新建文件夹";
		String menuTxt = "E:\\BaiduYunDownload\\第六季\\新建文件夹\\menu.txt";
		// fileRen.ren(folder);
		// 测试越界的删除
		AbstractWinFileRen fileRen2 = new WinFileNameDelete().setDeleteStart(10).setDeleteCount(2);
		fileRen2.ren(folder);
		// 测试越界(负数)的删除
		fileRen2 = new WinFileNameDelete().setDeleteStart(-1).setDeleteCount(-1);
		fileRen2.ren(folder);
		// 测试临界的删除
		fileRen2 = new WinFileNameDelete().setDeleteStart(7).setDeleteCount(1);
		fileRen2.ren(folder);
		// 测试从一个txt菜单中取文件来删除
		// fileRen2.ren(menuTxt);

	}
}
