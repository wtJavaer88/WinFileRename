package com.batch.ren;

import com.wnc.basic.BasicStringUtil;

/**
 * 修改文件扩展名
 * 
 * @author cpr216
 * 
 */
public class WinFileNameExtend extends AbstractWinFileRen {

	public String getExtendName() {
		return renParameters.getExtendName();
	}

	public WinFileNameExtend setExtendName(String extendName) {
		this.renParameters.setExtendName(extendName);
		return this;
	}

	@Override
	public String renOneFile(String fileName, String extendName) {
		String newExtend = getExtendName();
		if (BasicStringUtil.isNullString(newExtend)) {
			return null;
		}
		if (!newExtend.startsWith(".")) {
			newExtend = "." + newExtend;
		}
		if (extendName.equalsIgnoreCase(newExtend)) {
			return null;
		}
		String result = fileName + newExtend;
		return result;
	}
}
