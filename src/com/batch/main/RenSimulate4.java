package com.batch.main;

import com.batch.AbstractWinFileRen;
import com.batch.WinFileNameDelete;

public class RenSimulate4
{
    public static void main(String[] args)
    {
        String folder = "C:\\Users\\cpr216\\Downloads\\字幕\\Person.of.Interest.S03\\";
        // 序号对齐
        AbstractWinFileRen fileRen2 = new WinFileNameDelete().setDeleteStart(1)
                .setDeleteCount(27);
        fileRen2.closeTestModel();
        // fileRen2.ren(folder);

        fileRen2 = new WinFileNameDelete().setDeleteStr("Person.of.Interest.");
        // fileRen2.openTestModel();
        fileRen2.ren(folder);
    }
}
