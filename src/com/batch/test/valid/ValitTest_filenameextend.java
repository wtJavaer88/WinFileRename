package com.batch.test.valid;

import java.io.File;

import com.batch.valid.FileNameExtendValitor;
import com.batch.valid.Valitor;

public class ValitTest_filenameextend
{
    public static void main(String[] args)
    {
        String folder = "E:\\BaiduYunDownload\\第六季\\新建文件夹\\";
        File f = new File(folder + "新建文件夹.zip");
        Valitor fileSizeVa = new FileNameExtendValitor("zip");
        System.out.println(fileSizeVa.valid(f));

        fileSizeVa = new FileNameExtendValitor(".txt", ".Zip");
        System.out.println(fileSizeVa.valid(f));

        fileSizeVa = new FileNameExtendValitor(false, "Zip", "java");
        System.out.println(fileSizeVa.valid(f));

        fileSizeVa = new FileNameExtendValitor();
        System.out.println(fileSizeVa.valid(f));
    }
}
