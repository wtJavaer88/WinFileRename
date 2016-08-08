package com.batch.main;

import com.batch.ren.AbstractWinFileRen;
import com.batch.ren.WinFileNameDelete;

public class RenSimulate6
{
    public static void main(String[] args)
    {
        String folder = "D:\\Users\\wnc\\oral\\字幕\\50.Best.Cartoons\\";
        // 序号对齐
        AbstractWinFileRen fileRen2 = new WinFileNameDelete()
                .setDeleteStr(".中英文");
        // fileRen2.closeTestModel();
        fileRen2.ren(folder);

        // fileRen2 = new WinFileNameExtend().setExtendName(".srt");
        // fileRen2.closeTestModel();
        // fileRen2.ren(folder);

    }
}
