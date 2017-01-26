package com.util;

public class PageUtil {
	public static Page createPage(int currentPage, int everyPageNum, int totalCount) {
		int beginIndex = (currentPage - 1) * everyPageNum;
		int totalPage = totalCount % everyPageNum == 0 ? totalCount / everyPageNum : totalCount / everyPageNum + 1;
		boolean hasPrePage=currentPage==1?false:true;
		boolean hasNextPage=currentPage==totalPage||totalPage==0?false:true;
		return new Page(everyPageNum, totalPage, totalCount, currentPage, beginIndex, hasPrePage, hasNextPage);
	}
}
