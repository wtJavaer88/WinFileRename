package com.batch.test;

import com.batch.AbstractWinFileRen;
import com.batch.WinFileNameIndex;

public class CopyOftestIndex
{
    public static void main(String[] args)
    {
        String folder = "E:\\BaiduYunDownload\\第六季\\新建文件夹";
        String menuTxt = "E:\\BaiduYunDownload\\第六季\\新建文件夹\\menu.txt";
        // 序号对齐
        AbstractWinFileRen fileRen2 = new WinFileNameIndex()
                .setIndexAlign(true).setIndexRule("<#>_<SELF>");
        // fileRen2.ren(folder);

        // // 序号不对齐
        // fileRen2 = new WinFileNameIndex()
        // .setIndexAlign(true).setIndexRule("<#>_<SELF>");
        // fileRen2.ren(folder);

        // 测试从一个txt菜单中取文件来替换
        fileRen2.ren(menuTxt);

    }
}
