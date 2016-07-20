package com.batch.main;

import com.batch.ren.AbstractWinFileRen;
import com.batch.ren.WinFileNameIndex;
import com.batch.ren.WinFileNameReplace;
import com.batch.valid.FileNameExtendValitor;

public class RenSimulate {
	public static void main(String[] args) {
		String folder = "D:\\Users\\cpr216\\Workspaces\\MyEclipse 10\\pdfmaker\\src\\test\\resources\\pdf\\";
		// 序号对齐
		AbstractWinFileRen fileRen2 = new WinFileNameReplace().setReplaceStr("\\d+-全文在线阅读：").openEnableExp();
		fileRen2.closeTestModel();
		fileRen2.addValitor(new FileNameExtendValitor(".pdf"));
		fileRen2.ren(folder);

		fileRen2 = new WinFileNameIndex().setIndexAlign(true).setIndexRule("<#>_<SELF>");
		fileRen2.closeTestModel();
		fileRen2.addValitor(new FileNameExtendValitor(".pdf"));
		fileRen2.ren(folder);
	}
}
