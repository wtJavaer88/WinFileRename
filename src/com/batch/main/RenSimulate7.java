package com.batch.main;

import com.batch.ren.AbstractWinFileRen;
import com.batch.ren.WinFileNameSelect;

public class RenSimulate7 {
	public static void main(String[] args) {
		String folder = "D:\\Users\\wnc\\oral\\音频\\Person.of.Interest.S03\\";
		// 序号对齐
		AbstractWinFileRen fileRen2 = new WinFileNameSelect().setSelectStart(20).setSelectCount(6);
		fileRen2.closeTestModel();
		fileRen2.ren(folder);

	}
}
