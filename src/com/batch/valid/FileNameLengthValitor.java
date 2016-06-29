package com.batch.valid;

import java.io.File;

import com.batch.util.FileNameUtil;

public class FileNameLengthValitor implements Valitor
{
    @Override
    public String toString()
    {
        return "文件名长度(FileNameLengthValitor) [min=" + min + ", max=" + max
                + "]";
    }

    private int min;
    private int max;

    public FileNameLengthValitor(int min, int max)
    {
        if(min > max)
        {
            throw new IllegalArgumentException("最小值不能大于最大值");
        }
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean valid(File file)
    {

        String name = FileNameUtil.getFileNameNoExtend(file.getName());
        int length = name.length();
        if(length >= min && length <= max)
        {
            return true;
        }
        return false;
    }

}
