package com.batch.ren;

public class WinFileNameReplace extends AbstractWinFileRen {
	public boolean isEnableReverse() {
		return this.renParameters.isEnableReverse();
	}

	public WinFileNameReplace openEnableReverse() {
		this.renParameters.setEnableReverse(true);
		return this;
	}

	public boolean isEnableExp() {
		return this.renParameters.isEnableExp();
	}

	public WinFileNameReplace openEnableExp() {
		this.renParameters.setEnableExp(true);
		return this;
	}

	public String getReplaceStr() {
		return renParameters.getReplaceStr();
	}

	public WinFileNameReplace setReplaceStr(String selectStr) {
		this.renParameters.setReplaceStr(selectStr);
		return this;
	}

	public String getReplaceTargetStr() {
		return renParameters.getReplaceTargetStr();
	}

	public WinFileNameReplace setReplaceTargetStr(String targetStr) {
		this.renParameters.setReplaceTargetStr(targetStr);
		return this;
	}

	public int getSelectStart() {
		return renParameters.getSelectStart();
	}

	public WinFileNameReplace setSelectStart(int SelectStart) {
		this.renParameters.setSelectStart(SelectStart);
		return this;
	}

	public int getSelectCount() {
		return renParameters.getSelectCount();
	}

	public WinFileNameReplace setSelectCount(int SelectCount) {
		this.renParameters.setSelectCount(SelectCount);
		return this;
	}

	@Override
	/**
	 * 参数不合法就不处理了
	 */
	public String renOneFile(String fileName, String extendName) {
		String selectStr = getReplaceStr();
		if (selectStr == null) {
			return null;
		}
		String targetStr = getReplaceTargetStr();
		targetStr = (targetStr == null) ? "" : targetStr;
		if (isEnableExp()) {
			return fileName.replaceAll(selectStr, targetStr) + extendName;
		} else {
			// 去找区间替换
			int s = getSelectStart() - 1;
			int e = getSelectCount();
			if (s == 0 || e == 0 || !targetStr.equals("")) {
				// 如果没有指定区间,则替换给定字符串
				return fileName.replace(selectStr, targetStr) + extendName;
			}
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
				return fileName.substring(0, s) + targetStr + (e + 1 < length ? fileName.substring(e + 1) : "")
						+ extendName;
			}

			return fileName.substring(0, s) + targetStr + fileName.substring(e + s) + extendName;
		}
	}
}
