package com.batch.ren;

import com.wnc.basic.BasicStringUtil;

public class WinFileNameIndex extends AbstractWinFileRen
{

    int fileIndex = 0;

    public String getIndexRule()
    {
        return renParameters.getIndexRule();
    }

    /**
     * <pre>
     * 设置命名规则
     *  <#> 不可少,表示数字
     *  <SELF> 表示原来的文件名
     *  两者可以组合<#>_<SELF>
     * </pre>
     * 
     * @param insertStr
     * @return
     */
    public WinFileNameIndex setIndexRule(String insertStr)
    {
        this.renParameters.setIndexRule(insertStr);
        return this;
    }

    public boolean isIndexAlign()
    {
        return renParameters.isIndexAlign();
    }

    /**
     * 设置数字长度是否对齐
     * 
     * @param insertAlign
     * @return
     */
    public WinFileNameIndex setIndexAlign(boolean insertAlign)
    {
        this.renParameters.setIndexAlign(insertAlign);
        return this;
    }

    @Override
    public String renOneFile(String fileName, String extendName)
    {
        fileIndex++;
        String rule = getIndexRule();

        String indexStr = fileIndex + "";
        if(isIndexAlign())
            indexStr = BasicStringUtil.fillLeftStringNotruncate(indexStr,
                    (this.fileCounts + "").length(), "0");
        String result = rule.replace("<#>", indexStr).replace("<SELF>",
                fileName)
                + extendName;
        return result;
    }
}
