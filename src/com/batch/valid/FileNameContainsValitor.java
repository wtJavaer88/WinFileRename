package com.batch.valid;

import java.io.File;
import java.util.Arrays;

import com.batch.util.FileNameUtil;

public class FileNameContainsValitor implements Valitor
{
    private String[] keys;
    private boolean ignoreCase = true;

    public FileNameContainsValitor(boolean ignoreCase, String... args)
    {
        this.ignoreCase = ignoreCase;
        if(args == null || args.length == 0)
        {
            throw new IllegalArgumentException(
                    "FileNameContainsValitor至少需要一个字符串参数!");
        }
        this.keys = args;
    }

    /**
     * 默认大小写敏感,不带后缀,文件名必须全部包含给定的参数
     * 
     * @param args
     */
    public FileNameContainsValitor(String... args)
    {
        this(true, args);
    }

    @Override
    public String toString()
    {
        return "文件名包含(FileNameContainsValitor) [keys=" + Arrays.toString(keys)
                + ", ignoreCase=" + ignoreCase + "]";
    }

    @Override
    public boolean valid(File file)
    {
        for (String key : keys)
        {
            String name = FileNameUtil.getFileNameNoExtend(file.getName());
            if(ignoreCase)
            {
                name = name.toUpperCase();
                key = key.toUpperCase();
            }

            if(!name.contains(key))
            {
                return false;
            }
        }
        return true;
    }

}
