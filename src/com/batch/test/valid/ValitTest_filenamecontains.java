package com.batch.test.valid;

import java.io.File;

import com.batch.valid.FileNameContainsValitor;
import com.batch.valid.Valitor;

public class ValitTest_filenamecontains
{
    public static void main(String[] args)
    {
        String folder = "E:\\BaiduYunDownload\\第六季\\新建文件夹\\";
        File f = new File(folder + "新建文件夹.zip");
        Valitor fileSizeVa = new FileNameContainsValitor("新", "新建");
        System.out.println(fileSizeVa.valid(f));

        f = new File(folder + "File_07.txt");
        fileSizeVa = new FileNameContainsValitor("f", "e_07");
        System.out.println(fileSizeVa.valid(f));

        fileSizeVa = new FileNameContainsValitor(false, "f", "e_07");
        System.out.println(fileSizeVa.valid(f));

        fileSizeVa = new FileNameContainsValitor();
        System.out.println(fileSizeVa.valid(f));
    }
}
