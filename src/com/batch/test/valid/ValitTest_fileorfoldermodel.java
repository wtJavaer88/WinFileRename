package com.batch.test.valid;

import com.batch.ren.AbstractWinFileRen;
import com.batch.ren.WinFileNameSelect;
import com.batch.valid.FileOrFolderModelValitor;

public class ValitTest_fileorfoldermodel {
	// 改名前:D:\temp\ren\新建文本文档1.txt
	// 改名前:D:\temp\ren\1 - 副本 (2)
	// 改名后:D:\temp\ren\2
	// 改名后:D:\temp\ren\1.txt
	// 改名前:D:\temp\ren\1 - 副本 (3)
	// 改名前:D:\temp\ren\1 - 副本 (4)
	// 改名后:D:\temp\ren\4
	// 改名后:D:\temp\ren\3
	public static void main(String[] args) {
		String folder = "D:\\temp\\ren\\";
		// 序号对齐
		AbstractWinFileRen fileRen2 = new WinFileNameSelect().openEnableReverse().setReplaceStr("\\d+");
		// fileRen2.closeTestModel();
		// fileRen2.addValitor(new FileOrFolderModelValitor(true, true));
		// fileRen2.addValitor(new FileOrFolderModelValitor(true, false));
		fileRen2.addValitor(new FileOrFolderModelValitor(false, true));
		fileRen2.ren(folder);
	}

}
