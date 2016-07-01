package com.batch.test.valid;

import java.io.File;

import com.batch.valid.FileNameMatcherValitor;
import com.batch.valid.Valitor;

public class ValitTest_filenamematcher
{
    public static void main(String[] args)
    {
        String folder = "E:\\BaiduYunDownload\\第六季\\新建文件夹\\";
        File f = new File(folder + "File_01.atXt");
        Valitor fileSizeVa = new FileNameMatcherValitor(false, ".*\\.txt");
        System.out.println(fileSizeVa.valid(f));

        fileSizeVa = new FileNameMatcherValitor(true, ".txt");
        System.out.println(fileSizeVa.valid(f));

        fileSizeVa = new FileNameMatcherValitor(true, "^file_\\d+.*txt$");
        System.out.println(fileSizeVa.valid(f));

        fileSizeVa = new FileNameMatcherValitor(true, "^[^0-9].*txt$");
        System.out.println(fileSizeVa.valid(f));
    }
}
