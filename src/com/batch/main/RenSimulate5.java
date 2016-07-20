package com.batch.main;

import com.batch.AbstractWinFileRen;
import com.batch.WinFileNameDelete;

public class RenSimulate5
{
    public static void main(String[] args)
    {
        String folder = "C:\\Users\\cpr216\\Downloads\\字幕\\Gravity.Falls.S02\\";
        // 序号对齐
        AbstractWinFileRen fileRen2 = new WinFileNameDelete()
                .setDeleteStr("Gravity.Falls.");
        fileRen2.closeTestModel();
        fileRen2.ren(folder);
        int i = 0;
        while (i++ < 100)
        {
            fileRen2 = new WinFileNameDelete().setDeleteStart(7)
                    .setDeleteCount(1);
            fileRen2.closeTestModel();
            fileRen2.ren(folder);
        }
        // fileRen2.openTestModel();
    }
}
