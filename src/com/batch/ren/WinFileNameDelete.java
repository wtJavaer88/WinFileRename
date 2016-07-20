package com.batch.ren;

public class WinFileNameDelete extends AbstractWinFileRen {
	public boolean isEnableReverse() {
		return this.renParameters.isEnableReverse();
	}

	public WinFileNameDelete openEnableReverse() {
		this.renParameters.setEnableReverse(true);
		return this;
	}

	public boolean isEnableExp() {
		return this.renParameters.isEnableExp();
	}

	public WinFileNameDelete openEnableExp() {
		this.renParameters.setEnableExp(true);
		return this;
	}

	public String getDeleteStr() {
		return renParameters.getDeleteStr();
	}

	public WinFileNameDelete setDeleteStr(String deleteStr) {
		this.renParameters.setDeleteStr(deleteStr);
		return this;
	}

	public int getDeleteStart() {
		return renParameters.getSelectStart();
	}

	public WinFileNameDelete setDeleteStart(int deleteStart) {
		this.renParameters.setSelectStart(deleteStart);
		return this;
	}

	public int getDeleteCount() {
		return renParameters.getSelectCount();
	}

	public WinFileNameDelete setDeleteCount(int deleteCount) {
		this.renParameters.setSelectCount(deleteCount);
		return this;
	}

	/**
	 * 如果给定的参数不合法,不处理
	 */
	public String renOneFile(String fileName, String extendName) {
		String deleteStr = getDeleteStr();
		if (isEnableExp()) {
			return fileName.replaceAll(deleteStr, "") + extendName;
		} else {
			if (deleteStr != null && deleteStr.length() > 0) {
				return fileName.replace(deleteStr, "") + extendName;
			} else {
				int s = getDeleteStart() - 1;
				int e = getDeleteCount();
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
					s = length - (getDeleteStart() + getDeleteCount() - 1);
					e = length - getDeleteStart();
					return fileName.substring(0, s) + (e + 1 < length ? fileName.substring(e + 1) : "") + extendName;
				}

				return fileName.substring(0, s) + fileName.substring(e + s) + extendName;
			}
		}
	}

}
