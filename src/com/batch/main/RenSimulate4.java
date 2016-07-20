package com.batch.main;

import com.batch.ren.AbstractWinFileRen;
import com.batch.ren.WinFileNameDelete;

public class RenSimulate4 {
	public static void main(String[] args) {
		String folder = "D:\\Users\\wnc\\oral\\字幕\\Person.of.Interest.S01";
		// 序号对齐
		AbstractWinFileRen fileRen2 = new WinFileNameDelete().setDeleteStart(1).setDeleteCount(2);
		// fileRen2.closeTestModel();
		fileRen2.ren(folder);

		fileRen2 = new WinFileNameDelete().setDeleteStr("Person.of.Interest.");
		// fileRen2.openTestModel();
		// fileRen2.ren(folder);
	}
}
