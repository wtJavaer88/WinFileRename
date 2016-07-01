package com.batch.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.wnc.basic.BasicFileUtil;
import com.wnc.tools.FileOp;

public class FileNameUtil
{
    public static String getFolder(String filePath)
    {
        int separatorPos = filePath.lastIndexOf("\\");
        if(separatorPos != -1)
        {
            return filePath.substring(0, separatorPos);
        }
        return filePath;
    }

    public static String getFileExtend(String filePath)
    {
        int dotPos = filePath.lastIndexOf(".");
        if(dotPos == -1)
        {
            return "";
        }
        return filePath.substring(dotPos);
    }

    public static String getFileNameNoExtend(String filePath)
    {
        int dotPos = filePath.lastIndexOf(".");
        int separatorPos = filePath.lastIndexOf("\\");
        if(dotPos != -1)
        {
            if(separatorPos != -1)
            {
                return filePath.substring(separatorPos + 1, dotPos);
            }
            else
            {
                return filePath.substring(0, dotPos);
            }
        }
        else
        {
            if(separatorPos != -1)
            {
                return filePath.substring(separatorPos + 1);
            }

        }
        return filePath;
    }

    public static File[] getFilesFromTxt(String txt)
    {
        List<String> files = FileOp.readFrom(txt, "UTF-8");
        List<File> list = new ArrayList<File>();
        for (String file : files)
        {
            if(BasicFileUtil.isExistFile(file))
                list.add(new File(file));
            else
            {
                Logger.logErr(file + " 文件不存在");
            }
        }
        return list.toArray(new File[list.size()]);
    }
}
