package com.batch.test;

import com.batch.AbstractWinFileRen;
import com.batch.WinFileNameReplace;

public class CopyOftestRep
{
    public static void main(String[] args)
    {
        String folder = "E:\\BaiduYunDownload\\第六季\\新建文件夹";
        String menuTxt = "E:\\BaiduYunDownload\\第六季\\新建文件夹\\menu.txt";
        // 测试临界的替换
        AbstractWinFileRen fileRen2 = new WinFileNameReplace()
                .setEnableExp(false).setTargetStr("CCC").setReplaceStart(8)
                .setReplaceCount(1);
        fileRen2.ren(folder);
        // 测试越界的替换,越界不处理
        fileRen2 = new WinFileNameReplace().setEnableExp(false)
                .setTargetStr("CCC").setReplaceStart(9).setReplaceCount(1);
        fileRen2.ren(folder);
        // 测试倒序的替换
        fileRen2 = new WinFileNameReplace().setEnableExp(false)
                .setTargetStr("AAA").setReplaceStart(1).setReplaceCount(1)
                .setEnableReverse(true);
        // fileRen2.ren(folder);

        fileRen2 = new WinFileNameReplace().setEnableExp(false)
                .setTargetStr("AAA").setReplaceStart(2).setReplaceCount(2)
                .setEnableReverse(true);
        // fileRen2.ren(folder);

        fileRen2 = new WinFileNameReplace().setEnableExp(false)
                .setTargetStr("AAA").setReplaceStart(2).setReplaceCount(7)
                .setEnableReverse(true);
        fileRen2.ren(folder);

        // 测试从一个txt菜单中取文件来替换
        // fileRen2.ren(menuTxt);

        fileRen2 = new WinFileNameReplace().setEnableExp(true)
                .setTargetStr("AAA").setReplaceStr(")[fF]ile")
                .setEnableReverse(true);
        // fileRen2.ren(folder);

    }
}
