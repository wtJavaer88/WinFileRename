package com.batch;

public class RenParameters
{

    private boolean enableExp;
    private boolean enableReverse;

    private String deleteStr;
    private int deleteStart;
    private int deleteCount;

    private String replaceStr;
    private String targetStr;
    private int replaceStart;
    private int replaceCount;
    private int replacePos;

    private int insertPos;
    private String insertStr;

    private String indexRule;
    private boolean indexAlign;

    private String extendName;
    private boolean isLowerExtend;

    public String getTargetStr()
    {
        return targetStr;
    }

    public void setTargetStr(String targetStr)
    {
        this.targetStr = targetStr;
    }

    public boolean isIndexAlign()
    {
        return indexAlign;
    }

    public void setIndexAlign(boolean indexAlign)
    {
        this.indexAlign = indexAlign;
    }

    public String getInsertStr()
    {
        return insertStr;
    }

    public void setInsertStr(String insertStr)
    {
        this.insertStr = insertStr;
    }

    public boolean isEnableExp()
    {
        return enableExp;
    }

    public void setEnableExp(boolean enableExp)
    {
        this.enableExp = enableExp;
    }

    public String getDeleteStr()
    {
        return deleteStr;
    }

    public void setDeleteStr(String deleteStr)
    {
        this.deleteStr = deleteStr;
    }

    public int getDeleteStart()
    {
        return deleteStart;
    }

    public void setDeleteStart(int deleteStart)
    {
        this.deleteStart = deleteStart;
    }

    public int getDeleteCount()
    {
        return deleteCount;
    }

    public void setDeleteCount(int deleteCount)
    {
        this.deleteCount = deleteCount;
    }

    public String getReplaceStr()
    {
        return replaceStr;
    }

    public void setReplaceStr(String replaceStr)
    {
        this.replaceStr = replaceStr;
    }

    public int getReplaceStart()
    {
        return replaceStart;
    }

    public void setReplaceStart(int replaceStart)
    {
        this.replaceStart = replaceStart;
    }

    public int getReplaceCount()
    {
        return replaceCount;
    }

    public void setReplaceCount(int replaceCount)
    {
        this.replaceCount = replaceCount;
    }

    public int getReplacePos()
    {
        return replacePos;
    }

    public void setReplacePos(int replacePos)
    {
        this.replacePos = replacePos;
    }

    public int getInsertPos()
    {
        return insertPos;
    }

    public void setInsertPos(int insertPos)
    {
        this.insertPos = insertPos;
    }

    public String getIndexRule()
    {
        return indexRule;
    }

    public void setIndexRule(String indexRule)
    {
        this.indexRule = indexRule;
    }

    public String getExtendName()
    {
        return extendName;
    }

    public void setExtendName(String extendName)
    {
        this.extendName = extendName;
    }

    public boolean isLowerExtend()
    {
        return isLowerExtend;
    }

    public void setLowerExtend(boolean isLowerExtend)
    {
        this.isLowerExtend = isLowerExtend;
    }

    @Override
    public String toString()
    {
        return "RenParameters [(开启正则)enableExp=" + enableExp
                + ", (开启倒序)enableReverse=" + enableReverse
                + ", (删除源)deleteStr=" + deleteStr + ", deleteStart="
                + deleteStart + ", deleteCount=" + deleteCount
                + ", (替换源)replaceStr=" + replaceStr + ", (替换目标)targetStr="
                + targetStr + ", replaceStart=" + replaceStart
                + ", replaceCount=" + replaceCount + ", replacePos="
                + replacePos + ", insertPos=" + insertPos + ", insertStr="
                + insertStr + ", indexRule=" + indexRule + ", indexAlign="
                + indexAlign + ", extendName=" + extendName
                + ", isLowerExtend=" + isLowerExtend + "]";
    }

    public boolean isEnableReverse()
    {
        return enableReverse;
    }

    public void setEnableReverse(boolean enableReverse)
    {
        this.enableReverse = enableReverse;
    }
}
