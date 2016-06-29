package com.batch;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.batch.util.FileNameUtil;
import com.batch.util.SerializableUtil;
import com.batch.valid.Valitor;
import com.wnc.basic.BasicDateUtil;
import com.wnc.basic.BasicFileUtil;

public abstract class AbstractWinFileRen
{
    private final String logDir = "D:\\log\\rename\\";
    protected RenParameters renParameters = new RenParameters();
    protected String conflictStr = "(%d)";
    protected Map<String, String> renMap = new HashMap<String, String>();// 改后的文件名作为key
    protected Map<String, Integer> targetRepeatTimesMap = new HashMap<String, Integer>();
    protected int fileCounts = 0;
    protected List<Valitor> valitors = new ArrayList<Valitor>();
    protected boolean testModel = true;
    protected File[] files = null;

    public AbstractWinFileRen()
    {
        this.renMap.clear();
        this.targetRepeatTimesMap.clear();
        this.valitors.clear();
        this.fileCounts = 0;
    }

    /**
     * 开启测试模式,不执行真正的改名.相当于预览
     */
    public void openTestModel()
    {
        testModel = true;
    }

    /**
     * 关闭预览
     */
    public void closeTestModel()
    {
        testModel = false;
    }

    public void addValitor(Valitor valitor)
    {
        this.valitors.add(valitor);
    }

    public void ren(String folder)
    {
        log("");
        log(BasicDateUtil.getCurrentDateTimeString() + " 修改目录:" + folder
                + " 参数: " + renParameters);
        log("校验器个数" + valitors.size() + " 校验器参数: " + valitors);

        if(BasicFileUtil.isExistFolder(folder))
        {
            files = new File(folder).listFiles();
        }
        else if(BasicFileUtil.isExistFile(folder))
        {
            files = FileNameUtil.getFilesFromTxt(folder);
        }
        else
        {
            throw new RuntimeException("请至少给定一个文件夹或者文本文件路径!");
        }
        if(files != null && files.length > 0)
        {
            try
            {
                loopRename(files);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
                logErr(BasicDateUtil.getCurrentDateTimeString() + " "
                        + ex.getMessage());
                logErr(Arrays.toString(ex.getStackTrace()));
                logErr("\r\n");
                new RuntimeException("发生异常:" + ex.getMessage());
            }
        }
        SerializableUtil.serializableObject(logDir, renMap);
    }

    public Map<String, String> getRenMap()
    {
        return renMap;
    }

    private void loopRename(File[] files)
    {
        fileCounts = files.length;
        for (File file : files)
        {
            if(!valid(file))
            {
                continue;
            }
            String absolutePath = file.getAbsolutePath();
            String folder = FileNameUtil.getFolder(absolutePath);
            String fileName = FileNameUtil.getFileNameNoExtend(absolutePath);
            String extendName = FileNameUtil.getFileExtend(absolutePath);

            String target = renOneFile(fileName, extendName);
            if(target != null)
            {
                log("改名前:" + absolutePath);
                if(!targetRepeatTimesMap.containsKey(target))
                {
                    // 初始重复值为1,表示该文件名独一无二
                    targetRepeatTimesMap.put(target, 1);
                }
                else
                {
                    // 如果已经有了,则必然重复,重复值+1
                    int count = targetRepeatTimesMap.get(target);
                    targetRepeatTimesMap.remove(target);
                    targetRepeatTimesMap.put(target, count + 1);
                }
                if(targetRepeatTimesMap.get(target) > 1)
                {
                    // System.out.println("target重复:" + target + "  "
                    // + FileNameUtil.getFileNameNoExtend(target));
                    target = String.format(fileName + conflictStr + extendName,
                            targetRepeatTimesMap.get(target));
                }
                String targetPath = BasicFileUtil.getMakeFilePath(folder,
                        target);
                log("改名后:" + targetPath);
                if(!this.testModel)
                    BasicFileUtil.renameFile(absolutePath, targetPath);
                renMap.put(targetPath, absolutePath);
            }
        }
    }

    private boolean valid(File file)
    {
        for (Valitor valitor : valitors)
        {
            if(!valitor.valid(file))
            {
                return false;
            }
        }
        return true;
    }

    private void log(String msg)
    {

        if(!BasicFileUtil.isExistFolder(logDir))
        {
            throw new RuntimeException("日志文件夹不存在!");
        }
        System.out.println(msg);
        BasicFileUtil.writeFileString(
                logDir + "renlog" + BasicDateUtil.getCurrentDateString()
                        + ".txt", msg + "\r\n", null, true);
    }

    private void logErr(String msg)
    {
        if(!BasicFileUtil.isExistFolder("D:\\log\\rename\\"))
        {
            throw new RuntimeException("日志文件夹不存在!");
        }
        BasicFileUtil
                .writeFileString(
                        logDir + "renErrlog"
                                + BasicDateUtil.getCurrentDateString() + ".txt",
                        msg.replace(",", "\r\n") + "\r\n", null, true);

    }

    /**
     * 返回修改后的文件名
     * 
     * @param fileName
     * @param extendName
     * @return
     */
    public abstract String renOneFile(String fileName, String extendName);
}
