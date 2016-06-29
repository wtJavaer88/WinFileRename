package com.batch.test;

import com.batch.AbstractWinFileRen;
import com.batch.WinFileNameReplace;

public class testRep
{
    public static void main(String[] args)
    {
        System.out.println("ddd".substring(3));
        // 测试正则表达式的删除
        AbstractWinFileRen fileRen = new WinFileNameReplace()
                .setEnableExp(true).setReplaceStr("\\d+");
        String folder = "E:\\BaiduYunDownload\\第六季\\新建文件夹";
        String menuTxt = "E:\\BaiduYunDownload\\第六季\\新建文件夹\\menu.txt";
        fileRen.ren(folder);
        // 测试越界的替换
        AbstractWinFileRen fileRen2 = new WinFileNameReplace()
                .setEnableExp(false).setReplaceStr("AAA").setReplaceStart(24)
                .setReplaceCount(4);
        fileRen2.ren(folder);
        // 测试越界(负数)的替换
        fileRen2 = new WinFileNameReplace().setEnableExp(false)
                .setReplaceStr("AAA").setReplaceStart(-1).setReplaceCount(-1);
        fileRen2.ren(folder);
        // 测试临界的删除
        fileRen2 = new WinFileNameReplace().setEnableExp(false)
                .setReplaceStr("AAA").setReplaceStart(7).setReplaceCount(1);
        fileRen2.ren(folder);

        // 测试从一个txt菜单中取文件来替换
        fileRen2.ren(menuTxt);

    }
}
