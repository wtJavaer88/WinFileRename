package com.batch.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.wnc.basic.BasicDateUtil;

public class SerializableUtil
{
    /**
     * 序列化
     * 
     * @param dir
     * @param obj
     */
    public static void serializableObject(String dir, Object obj)
    {
        FileOutputStream fos;
        try
        {
            String saveName = (BasicDateUtil.getCurrentDateTime() + ".tmp")
                    .replace(" ", "_").replace(":", "");
            String savePath = dir + saveName;
            fos = new FileOutputStream(savePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static Map<String, String> deverSerializableMap(String file)
    {
        Map<String, String> map = new HashMap<String, String>();
        try
        {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            map = (Map<String, String>) ois.readObject();
            System.out.println("gpa = " + map);
            ois.close();
            fis.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return map;
    }
}
