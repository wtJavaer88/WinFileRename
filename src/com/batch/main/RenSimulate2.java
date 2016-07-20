package com.batch.main;

import com.batch.ren.AbstractWinFileRen;
import com.batch.ren.WinFileNameReplace;
import com.batch.valid.FileNameExtendValitor;
import com.batch.valid.FileNameMatcherValitor;

public class RenSimulate2 {
	public static void main(String[] args) {
		switchTo(1);
	}

	private static void switchTo(int caseInt) {
		switch (caseInt) {
		case 1:
			ren();
			break;
		case 2:
			rollback();
			break;
		}
	}

	private static void ren() {
		for (int i = 5; i >= 1; i--) {
			int zeroCount = i;
			int indexLength = 6 - i;
			String folder = "E:\\Downloads\\toutiao\\articles\\";
			AbstractWinFileRen fileRen2 = new WinFileNameReplace().setReplaceStr("[")
					.setReplaceTargetStr("[" + repeat("0", zeroCount)).openEnableExp().setSelectStart(1)
					.setSelectCount(5);
			// fileRen2.closeTestModel();
			fileRen2.addValitor(new FileNameExtendValitor(".html"));
			fileRen2.addValitor(new FileNameMatcherValitor(true, "^\\[\\d{" + indexLength + "}\\].*.html"));
			fileRen2.ren(folder);
		}
	}

	/**
	 * 将前面多余的0都去掉
	 */
	private static void rollback() {
		String folder = "E:\\Downloads\\toutiao\\articles\\";
		// 序号对齐
		AbstractWinFileRen fileRen2 = new WinFileNameReplace().setReplaceStr("\\[0{1,}").setReplaceTargetStr("[")
				.openEnableExp();
		fileRen2.closeTestModel();
		fileRen2.addValitor(new FileNameExtendValitor(".html"));
		fileRen2.addValitor(new FileNameMatcherValitor(true, "^\\[0{1,}\\d{1,5}\\].*.html"));
		fileRen2.ren(folder);
	}

	private static String repeat(String str, int times) {
		int i = 1;
		String ret = str;
		while (i < times) {
			ret += str;
			i++;
		}
		return ret;
	}
}
