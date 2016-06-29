package com.batch.test;

import com.batch.AbstractWinFileRen;
import com.batch.WinFileNameInsert;

public class testInsert
{
    public static void main(String[] args)
    {
        // 测试开头的添加
        AbstractWinFileRen fileRen = new WinFileNameInsert().setInsertPos(0)
                .setInsertStr("AAA");
        String folder = "E:\\BaiduYunDownload\\第六季\\新建文件夹";
        String menuTxt = "E:\\BaiduYunDownload\\第六季\\新建文件夹\\menu.txt";
        fileRen.ren(folder);
        // 测试末尾的添加
        fileRen = new WinFileNameInsert().setInsertPos(-1).setInsertStr("AAA");
        fileRen.ren(folder);

        // 测试越界的添加
        fileRen = new WinFileNameInsert().setInsertPos(8).setInsertStr("AAA");
        fileRen.ren(folder);
        // 测试越界(负数)的添加
        fileRen = new WinFileNameInsert().setInsertPos(-2).setInsertStr("AAA");
        fileRen.ren(folder);

        // 测试中间的添加
        fileRen = new WinFileNameInsert().setInsertPos(5).setInsertStr("AAA");
        fileRen.ren(folder);
        // 测试中间 空字符串的添加
        fileRen = new WinFileNameInsert().setInsertPos(5);
        fileRen.ren(folder);
        // 测试中间 空格的添加
        fileRen = new WinFileNameInsert().setInsertPos(5).setInsertStr(" ");
        fileRen.ren(folder);

        // 测试从一个txt菜单中取文件来替换
        fileRen.ren(menuTxt);

    }
}
