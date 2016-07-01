package com.batch.main;

import com.batch.AbstractWinFileRen;
import com.batch.WinFileNameIndex;
import com.batch.valid.FileNameExtendValitor;

public class T
{
    public static void main(String[] args)
    {
        // System.out.println(System.currentTimeMillis());
        AbstractWinFileRen fileRen2 = new WinFileNameIndex()
                .setIndexAlign(true).setIndexRule("<#>_<SELF>");
        fileRen2.closeTestModel();
        fileRen2.addValitor(new FileNameExtendValitor(".htm"));
        fileRen2.ren("C:\\1.txt");
    }
}
