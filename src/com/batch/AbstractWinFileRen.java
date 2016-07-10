package com.batch;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import javax.swing.plaf.synth.SynthSpinnerUI;

import com.batch.util.FileNameUtil;
import com.batch.util.Logger;
import com.batch.valid.Valitor;
import com.wnc.basic.BasicDateUtil;
import com.wnc.basic.BasicFileUtil;

public abstract class AbstractWinFileRen
{

    protected RenParameters renParameters = new RenParameters();
    
    protected Map<String, String> renMap = new HashMap<String, String>();// 改后的文件名作为key
    protected int fileCounts = 0;
    protected List<Valitor> valitors = new ArrayList<Valitor>();
    protected static boolean testModel = true;
    protected File[] files = null;

    ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors
			.newFixedThreadPool(5);
    
    public AbstractWinFileRen()
    {
        this.renMap.clear();
        ProductQueen.clear();
        this.valitors.clear();
        this.fileCounts = 0;
    }

    public static boolean isTestModel()
    {
        return testModel;
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

    /**
     * 可以传入一个文件夹, 或者一个包含了文件列表的文本文件(需要是UTF-8格式)
     * 
     * <pre>
     *    如C:\\1.txt
     *    里面内容:
     *      D:\\test\\aaa1.htm
     *      D:\\test\\aaa2.htm
     *      D:\\test\\aaa3.htm
     *    那么程序将会修改txt里面的3个htm文件
     * </pre>
     * 
     * @param folder
     */
    public void ren(String folder)
    {
        boolean isDir = true;
        if(BasicFileUtil.isExistFolder(folder))
        {
            files = new File(folder).listFiles();
        }
        else if(BasicFileUtil.isExistFile(folder))
        {
            isDir = false;
            files = FileNameUtil.getFilesFromTxt(folder);
        }
        else
        {
            String message = folder + "非法,请至少给定一个文件夹或者文本文件路径!";
            Logger.logErr(message);
            throw new RuntimeException(message);
        }

        Logger.log("");
        Logger.log(BasicDateUtil.getCurrentDateTimeString()
                + (isDir ? " 修改目录:" : "修改指定文件中的文件列表 [") + folder + "] 参数: "
                + renParameters);
        Logger.log("校验器个数" + valitors.size() + " 校验器参数: " + valitors);

        if(files != null && files.length > 0)
        {
            try
            {
                loopRename(files);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
                Logger.logErr(BasicDateUtil.getCurrentDateTimeString() + " "
                        + ex.getMessage());
                Logger.logErr(Arrays.toString(ex.getStackTrace()));
                Logger.logErr("\r\n");
                new RuntimeException("发生异常:" + ex.getMessage());
            }
        }

        Logger.serialize(renMap);
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
            executeService(file);
        }
        executor.shutdown();
    }

	public boolean isAlive() {
		return executor.getActiveCount() > 0;
	}

    private void executeService(File file) {
    	executor.execute(new RenameTask(this, file));
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

    /**
     * 返回修改后的文件名
     * 
     * @param fileName
     * @param extendName
     * @return
     */
    public abstract String renOneFile(String fileName, String extendName);

	public synchronized void putNewPair(String targetPath, String absolutePath) {
		 this.renMap.put(targetPath, absolutePath);		
	}
}
