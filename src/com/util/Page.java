package com.util;

public class Page {
	private int everyPageNum;
	private int totalPage;
	private int totalCount;
	private int currentPage;
	private int beginIndex;
	private boolean hasPrePage;
	private boolean hasNextPage;

	public int getEveryPageNum() {
		return everyPageNum;
	}

	public void setEveryPageNum(int everyPageNum) {
		this.everyPageNum = everyPageNum;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getBeginIndex() {
		return beginIndex;
	}

	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}

	public boolean isHasPrePage() {
		return hasPrePage;
	}

	public void setHasPrePage(boolean hasPrePage) {
		this.hasPrePage = hasPrePage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public Page(int everyPageNum, int totalPage, int totalCount, int currentPage, int beginIndex, boolean hasPrePage,
			boolean hasNextPage) {
		super();
		this.everyPageNum = everyPageNum;
		this.totalPage = totalPage;
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.beginIndex = beginIndex;
		this.hasPrePage = hasPrePage;
		this.hasNextPage = hasNextPage;
	}

}
