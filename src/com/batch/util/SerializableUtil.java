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
    public static void serializableObject(String dir, Object obj)
    {
        FileOutputStream fos;
        try
        {
            fos = new FileOutputStream(dir
                    + (BasicDateUtil.getCurrentDateTimeString() + ".tmp")
                            .replace(" ", "_").replace(":", ""));
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
