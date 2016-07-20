package com.batch.test.valid;

import com.batch.ren.AbstractWinFileRen;
import com.batch.ren.WinFileNameIndex;
import com.batch.valid.FileNameContainsValitor;
import com.batch.valid.FileNameExtendValitor;
import com.batch.valid.FileNameLengthValitor;
import com.batch.valid.FileNameMatcherValitor;
import com.batch.valid.FileSizeValitor;

public class ValidRen
{
    public static void main(String[] args)
    {
        String folder = "E:\\BaiduYunDownload\\第六季\\新建文件夹";
        String menuTxt = "E:\\BaiduYunDownload\\第六季\\新建文件夹\\menu.txt";
        // 序号对齐
        AbstractWinFileRen fileRen2 = new WinFileNameIndex()
                .setIndexAlign(true).setIndexRule("<#>_<SELF>");
        fileRen2.openTestModel();
        fileRen2.addValitor(new FileNameContainsValitor("f", "e_"));
        fileRen2.addValitor(new FileNameExtendValitor(".txt", ".Zip"));
        fileRen2.addValitor(new FileNameMatcherValitor(true, "^file_\\d+.*txt$"));
        fileRen2.addValitor(new FileNameLengthValitor(7, 8));
        fileRen2.addValitor(new FileSizeValitor(60, 120));
        fileRen2.ren(folder);
    }
}
