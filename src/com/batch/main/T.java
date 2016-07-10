package com.batch.main;

import com.batch.AbstractWinFileRen;
import com.batch.WinFileNameDelete;
import com.batch.WinFileNameIndex;
import com.batch.valid.FileNameExtendValitor;

public class T
{
    public static void main(String[] args)
    {
    	test2();
//        test1();
    }

    private static void test2() {
		// System.out.println(System.currentTimeMillis());
        AbstractWinFileRen fileRen2 = new WinFileNameDelete().setEnableExp(true).setDeleteStr("\\d+");
//        fileRen2.closeTestModel();
        fileRen2.addValitor(new FileNameExtendValitor(".txt"));
        fileRen2.ren("D:\\1.txt");
	}
	private static void test1() {
		// System.out.println(System.currentTimeMillis());
        AbstractWinFileRen fileRen2 = new WinFileNameIndex()
                .setIndexAlign(true).setIndexRule("<#>_<SELF>");
//        fileRen2.closeTestModel();
        fileRen2.addValitor(new FileNameExtendValitor(".txt"));
        fileRen2.ren("D:\\1.txt");
	}
}
