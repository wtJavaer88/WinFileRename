package com.batch.util;

import java.util.Map;

import com.wnc.basic.BasicFileUtil;

public class RedoUtil
{
    /**
     * 参数格式: "D:\\log\\rename\\2016-06-28_175559.tmp"
     * 
     * @param filePath
     */
    public static void redo(String filePath)
    {
        Map<String, String> deverSerializableMap = SerializableUtil
                .deverSerializableMap(filePath);
        System.out.println(deverSerializableMap);
        for (Map.Entry<String, String> entry : deverSerializableMap.entrySet())
        {
            BasicFileUtil.renameFile(entry.getKey(), entry.getValue());
        }
    }
}
