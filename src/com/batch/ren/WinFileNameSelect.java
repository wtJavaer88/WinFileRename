package com.batch.ren;

import com.wnc.basic.BasicStringUtil;
import com.wnc.string.PatternUtil;

/**
 * 修改文件名为选定的一段字符串
 * 
 * @author cpr216
 * 
 */
public class WinFileNameSelect extends AbstractWinFileRen {
	public boolean isEnableReverse() {
		return this.renParameters.isEnableReverse();
	}

	public WinFileNameSelect openEnableReverse() {
		this.renParameters.setEnableReverse(true);
		return this;
	}

	public String getReplaceStr() {
		return this.renParameters.getReplaceStr();
	}

	public WinFileNameSelect setReplaceStr(String replaceStr) {
		this.renParameters.setReplaceStr(replaceStr);
		return this;
	}

	public int getSelectCount() {
		return renParameters.getSelectCount();
	}

	public WinFileNameSelect setSelectCount(int selectCount) {
		this.renParameters.setSelectCount(selectCount);
		return this;
	}

	public int getSelectStart() {
		return renParameters.getSelectStart();
	}

	public WinFileNameSelect setSelectStart(int selectStart) {
		this.renParameters.setSelectStart(selectStart);
		return this;
	}

	@Override
	public String renOneFile(String fileName, String extendName) {
		if (BasicStringUtil.isNotNullString(getReplaceStr())) {
			if (!isEnableReverse()) {
				String firstPattern = PatternUtil.getFirstPattern(fileName, getReplaceStr());
				if (BasicStringUtil.isNullString(firstPattern)) {
					return null;
				}
				return firstPattern + extendName;
			} else {
				String firstPattern = PatternUtil.getLastPattern(fileName, getReplaceStr());
				if (BasicStringUtil.isNullString(firstPattern)) {
					return null;
				}
				return firstPattern + extendName;
			}
		}
		int s = getSelectStart() - 1;
		int e = getSelectCount();
		int length = fileName.length();
		if (e + s > length) {
			return null;
		}
		if (s > length) {
			return null;
		}
		if (s < 0) {
			return null;
		}
		if (e < 1) {
			return null;
		}

		if (isEnableReverse()) {
			s = length - (getSelectStart() + getSelectCount() - 1);
			e = length - getSelectStart();
			return fileName.substring(s, e + 1) + extendName;
		}

		return fileName.substring(s, s + e) + extendName;
	}
}
