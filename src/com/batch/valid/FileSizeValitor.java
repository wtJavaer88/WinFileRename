package com.batch.valid;

import java.io.File;

public class FileSizeValitor implements Valitor
{
    @Override
    public String toString()
    {
        return "文件大小(FileSizeValitor) [min=" + min + ", max=" + max + "]";
    }

    private long min;
    private long max;

    public FileSizeValitor(int min, int max)
    {
        if(min > max)
        {
            throw new IllegalArgumentException("文件大小的最小值不能大于最大值");
        }
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean valid(File file)
    {

        long length = file.length();
        if(length >= min && length <= max)
        {
            return true;
        }
        return false;
    }

}
