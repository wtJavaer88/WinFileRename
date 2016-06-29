package com.batch.valid;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileNameMatcherValitor implements Valitor
{
    @Override
    public String toString()
    {
        return "文件名正则匹配(FileNameMatcherValitor) [patternStr=" + patternStr
                + ", ignoreCase=" + ignoreCase + "]";
    }

    private String patternStr;
    private boolean ignoreCase = true;

    /**
     * 匹配的时候带上后缀一起匹配
     * 
     * @param ignoreCase
     * @param patternStr
     */
    public FileNameMatcherValitor(boolean ignoreCase, String patternStr)
    {
        if(patternStr == null)
        {
            throw new IllegalArgumentException("FileNameMatcherValitor表达式不能为空");
        }
        this.ignoreCase = ignoreCase;
        this.patternStr = patternStr;
    }

    @Override
    public boolean valid(File file)
    {
        String fileName = file.getName();
        if(ignoreCase)
        {
            Pattern pattern = Pattern.compile(patternStr,
                    Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(fileName);
            if(matcher.find())
            {
                // System.out.println("字符串" + fileNameNoExtend + "匹配模式"
                // + patternStr + "成功");
                return true;
            }
        }
        else
        {
            return fileName.matches(patternStr);
        }
        return false;
    }
}
