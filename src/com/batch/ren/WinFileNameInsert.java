package com.batch.ren;

public class WinFileNameInsert extends AbstractWinFileRen {

	public String getInsertStr() {
		return renParameters.getInsertStr();
	}

	public WinFileNameInsert setInsertStr(String insertStr) {
		this.renParameters.setInsertStr(insertStr);
		return this;
	}

	public int getInsertPos() {
		return renParameters.getInsertPos();
	}

	public WinFileNameInsert setInsertPos(int InsertPos) {
		this.renParameters.setInsertPos(InsertPos);
		return this;
	}

	public boolean isEnableReverse() {
		return this.renParameters.isEnableReverse();
	}

	public WinFileNameInsert openEnableReverse() {
		this.renParameters.setEnableReverse(true);
		return this;
	}

	@Override
	public String renOneFile(String fileName, String extendName) {
		String insertStr = getInsertStr();
		if (insertStr == null || insertStr.length() == 0) {
			return null;
		}
		int pos = getInsertPos();
		int length = fileName.length();
		if (isEnableReverse()) {
			pos = length - pos;
		}
		if (pos > length || pos < 0) {
			return null;
		}
		if (pos == 0) {
			return insertStr + fileName + extendName;
		} else if (pos == -1) {
			return (fileName + insertStr + extendName);
		} else {
			String str1 = fileName.substring(0, pos);
			String str2 = fileName.substring(pos);
			return str1 + insertStr + str2 + extendName;
		}
	}
}
