package com.batch.test;

import com.batch.ren.AbstractWinFileRen;
import com.batch.ren.WinFileNameReplace;

public class CopyOftestRep {
	public static void main(String[] args) {
		String folder = "E:\\BaiduYunDownload\\第六季\\新建文件夹";
		String menuTxt = "E:\\BaiduYunDownload\\第六季\\新建文件夹\\menu.txt";
		// 测试临界的替换
		AbstractWinFileRen fileRen2 = new WinFileNameReplace().openEnableExp().setReplaceTargetStr("CCC")
				.setSelectStart(8).setSelectCount(1);
		fileRen2.ren(folder);
		// 测试越界的替换,越界不处理
		fileRen2 = new WinFileNameReplace().openEnableExp().setReplaceTargetStr("CCC").setSelectStart(9)
				.setSelectCount(1);
		fileRen2.ren(folder);
		// 测试倒序的替换
		fileRen2 = new WinFileNameReplace().openEnableExp().setReplaceTargetStr("AAA").setSelectStart(1)
				.setSelectCount(1).openEnableReverse();
		// fileRen2.ren(folder);

		fileRen2 = new WinFileNameReplace().openEnableExp().setReplaceTargetStr("AAA").setSelectStart(2)
				.setSelectCount(2).openEnableReverse();
		// fileRen2.ren(folder);

		fileRen2 = new WinFileNameReplace().openEnableExp().setReplaceTargetStr("AAA").setSelectStart(2)
				.setSelectCount(7).openEnableReverse();
		fileRen2.ren(folder);

		// 测试从一个txt菜单中取文件来替换
		// fileRen2.ren(menuTxt);

		fileRen2 = new WinFileNameReplace().openEnableExp().setReplaceTargetStr("AAA").setReplaceStr(")[fF]ile")
				.openEnableReverse();
		// fileRen2.ren(folder);

	}
}
