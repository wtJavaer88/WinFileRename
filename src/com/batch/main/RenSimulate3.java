package com.batch.main;

import com.batch.ren.AbstractWinFileRen;
import com.batch.ren.WinFileNameReplace;
import com.batch.valid.FileNameExtendValitor;
import com.batch.valid.FileNameMatcherValitor;
import com.wnc.basic.BasicFileUtil;

public class RenSimulate3 {
	public static void main(String[] args) {
		long st = System.currentTimeMillis();
		switchTo(1);
		System.out.println("耗时:  " + (System.currentTimeMillis() - st) / 1000);
	}

	private static void switchTo(int caseInt) {
		switch (caseInt) {
		case 1:
			ren();
			break;
		case 2:
			rollback();
			break;
		case 3:
			createFiles();
		}
	}

	private static void createFiles() {
		for (int i = 1; i < 100000; i++) {
			BasicFileUtil.writeFileString(folder + "[" + i + "]AA.html", "", null, false);
		}
	}

	static String folder = "E:\\Downloads\\toutiao\\articles\\";

	private static void ren() {
		for (int i = 5; i >= 1; i--) {
			int zeroCount = i;
			int indexLength = 6 - i;
			AbstractWinFileRen fileRen2 = new WinFileNameReplace().setReplaceStr("[")
					.setReplaceTargetStr("[" + repeat("0", zeroCount));
			fileRen2.closeTestModel();
			fileRen2.addValitor(new FileNameExtendValitor(".html"));
			fileRen2.addValitor(new FileNameMatcherValitor(true, "^\\[\\d{" + indexLength + "}\\].*.html"));
			fileRen2.ren(folder);
			while (fileRen2.isAlive()) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			fileRen2.saveSerializeData();
		}
	}

	/**
	 * 将前面多余的0都去掉
	 */
	private static void rollback() {
		// 序号对齐
		AbstractWinFileRen fileRen2 = new WinFileNameReplace().setReplaceStr("\\[0{1,}").setReplaceTargetStr("[")
				.openEnableExp();
		fileRen2.closeTestModel();
		fileRen2.addValitor(new FileNameExtendValitor(".html"));
		fileRen2.addValitor(new FileNameMatcherValitor(true, "^\\[0\\d{5}\\].*.html$"));
		fileRen2.ren(folder);
		while (fileRen2.isAlive()) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		fileRen2.saveSerializeData();
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
