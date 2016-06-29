package com.batch;

public class WinFileNameReplace extends AbstractWinFileRen
{
    public boolean isEnableReverse()
    {
        return this.renParameters.isEnableReverse();
    }

    public WinFileNameReplace setEnableReverse(boolean enableReverse)
    {
        this.renParameters.setEnableReverse(enableReverse);
        return this;
    }

    public boolean isEnableExp()
    {
        return this.renParameters.isEnableExp();
    }

    public WinFileNameReplace setEnableExp(boolean enableExp)
    {
        this.renParameters.setEnableExp(enableExp);
        return this;
    }

    public String getReplaceStr()
    {
        return renParameters.getReplaceStr();
    }

    public WinFileNameReplace setReplaceStr(String replaceStr)
    {
        this.renParameters.setReplaceStr(replaceStr);
        return this;
    }

    public String getTargetStr()
    {
        return renParameters.getTargetStr();
    }

    public WinFileNameReplace setTargetStr(String targetStr)
    {
        this.renParameters.setTargetStr(targetStr);
        return this;
    }

    public int getReplaceStart()
    {
        return renParameters.getReplaceStart();
    }

    public WinFileNameReplace setReplaceStart(int replaceStart)
    {
        this.renParameters.setReplaceStart(replaceStart);
        return this;
    }

    public int getReplaceCount()
    {
        return renParameters.getReplaceCount();
    }

    public WinFileNameReplace setReplaceCount(int replaceCount)
    {
        this.renParameters.setReplaceCount(replaceCount);
        return this;
    }

    @Override
    /**
     * 参数不合法就不处理了
     */
    public String renOneFile(String fileName, String extendName)
    {
        String replaceStr = getReplaceStr();
        if(replaceStr == null)
        {
            replaceStr = "";
        }
        if(isEnableExp())
        {
            return fileName.replaceAll(replaceStr, getTargetStr()) + extendName;
        }
        else
        {
            int s = getReplaceStart() - 1;
            int e = getReplaceCount();
            if(s == 0 && e == 0)
            {
                // 如果没有指定区间,则替换给定字符串
                return fileName.replace(replaceStr, getTargetStr())
                        + extendName;
            }
            int length = fileName.length();
            if(e + s > length)
            {
                return null;
            }

            if(s > length)
            {
                return null;
            }
            if(s < 0)
            {
                return null;
            }
            if(e < 1)
            {
                return null;
            }

            if(isEnableReverse())
            {
                s = length - (getReplaceStart() + getReplaceCount() - 1);
                e = length - getReplaceStart();
                return fileName.substring(0, s) + getTargetStr()
                        + (e + 1 < length ? fileName.substring(e + 1) : "")
                        + extendName;
            }

            return fileName.substring(0, s) + getTargetStr()
                    + fileName.substring(e + s) + extendName;
        }
    }
}
