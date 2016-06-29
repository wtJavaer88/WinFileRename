package com.batch;

import com.wnc.basic.BasicStringUtil;

public class WinFileNameIndex extends AbstractWinFileRen
{

    int fileIndex = 0;

    public String getIndexRule()
    {
        return renParameters.getIndexRule();
    }

    public WinFileNameIndex setIndexRule(String insertStr)
    {
        this.renParameters.setIndexRule(insertStr);
        return this;
    }

    public boolean isIndexAlign()
    {
        return renParameters.isIndexAlign();
    }

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
