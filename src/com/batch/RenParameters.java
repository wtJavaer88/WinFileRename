package com.batch;

public class RenParameters {
	// 删除和替换模式用正则表达式replaceAll
	private boolean enableExp;
	// 倒序选择,与选择的两个值配合使用
	private boolean enableReverse;
	// 删除模式用
	private String deleteStr;
	// 选择,删除,替换,添加模式都可用
	private int selectStart;
	private int selectCount;
	// 替换模式用
	private String replaceStr;
	private String replaceTargetStr;
	// 插入模式用
	private int insertPos;
	private String insertStr;
	// 序列模式用
	private String indexRule;
	private boolean indexAlign;
	// 扩展名模式用
	private String extendName;

	public String getReplaceTargetStr() {
		return replaceTargetStr;
	}

	public void setReplaceTargetStr(String replaceTargetStr) {
		this.replaceTargetStr = replaceTargetStr;
	}

	public boolean isIndexAlign() {
		return indexAlign;
	}

	public void setIndexAlign(boolean indexAlign) {
		this.indexAlign = indexAlign;
	}

	public String getInsertStr() {
		return insertStr;
	}

	public void setInsertStr(String insertStr) {
		this.insertStr = insertStr;
	}

	public boolean isEnableExp() {
		return enableExp;
	}

	public void setEnableExp(boolean enableExp) {
		this.enableExp = enableExp;
	}

	public String getDeleteStr() {
		return deleteStr;
	}

	public void setDeleteStr(String deleteStr) {
		this.deleteStr = deleteStr;
	}

	public String getReplaceStr() {
		return replaceStr;
	}

	public void setReplaceStr(String replaceStr) {
		this.replaceStr = replaceStr;
	}

	public int getInsertPos() {
		return insertPos;
	}

	public void setInsertPos(int insertPos) {
		this.insertPos = insertPos;
	}

	public String getIndexRule() {
		return indexRule;
	}

	public void setIndexRule(String indexRule) {
		this.indexRule = indexRule;
	}

	public String getExtendName() {
		return extendName;
	}

	public void setExtendName(String extendName) {
		this.extendName = extendName;
	}

	@Override
	public String toString() {
		return "RenParameters [enableExp=" + enableExp + ", enableReverse=" + enableReverse + ", deleteStr=" + deleteStr
				+ ", selectStart=" + selectStart + ", selectCount=" + selectCount + ", replaceStr=" + replaceStr
				+ ", replaceTargetStr=" + replaceTargetStr + ", insertPos=" + insertPos + ", insertStr=" + insertStr
				+ ", indexRule=" + indexRule + ", indexAlign=" + indexAlign + ", extendName=" + extendName + "]";
	}

	public boolean isEnableReverse() {
		return enableReverse;
	}

	public void setEnableReverse(boolean enableReverse) {
		this.enableReverse = enableReverse;
	}

	public int getSelectStart() {
		return selectStart;
	}

	public void setSelectStart(int selectStart) {
		this.selectStart = selectStart;
	}

	public int getSelectCount() {
		return selectCount;
	}

	public void setSelectCount(int selectCount) {
		this.selectCount = selectCount;
	}
}
