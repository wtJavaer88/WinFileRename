package com.batch.test;

import java.io.IOException;

import com.batch.AbstractWinFileRen;
import com.batch.WinFileNameExtend;

public class CopyOftestExtend
{
    public static void main(String[] args) throws IOException
    {
        AbstractWinFileRen fileRen = new WinFileNameExtend().setExtendName(
                "jpg").setLowerExtend(true);
        String folder = "E:\\BaiduYunDownload\\第六季\\新建文件夹";
        fileRen.ren(folder);
    }
}
