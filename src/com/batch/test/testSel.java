package com.batch.test;

import com.batch.ren.AbstractWinFileRen;
import com.batch.ren.WinFileNameSelect;

public class testSel
{
    public static void main(String[] args)
    {
        System.out.println("ddd".substring(3));
        // 测试正则表达式的删除
        AbstractWinFileRen fileRen = new WinFileNameSelect().setSelectStart(20)
                .setSelectCount(6);
        String folder = "E:\\BaiduYunDownload\\怪诞小镇 Gravity falls 第2季（1-20）全\\";
        fileRen.closeTestModel();
        fileRen.ren(folder);
    }

}
