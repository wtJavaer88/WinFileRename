package com.batch.test.valid;

import java.io.File;

import com.batch.valid.FileNameLengthValitor;
import com.batch.valid.Valitor;

public class ValitTest_filenamelength
{
    public static void main(String[] args)
    {
        String folder = "E:\\BaiduYunDownload\\第六季\\新建文件夹\\";
        File f = new File(folder + "新建文件夹.zip");
        Valitor fileSizeVa = new FileNameLengthValitor(5, 5);
        System.out.println(fileSizeVa.valid(f));
    }
}
