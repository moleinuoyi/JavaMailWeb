package com.zwt.util;

public class PageUtil {
	public static Page createPage(int everyPage,int totalCount,int currentPage) {
		everyPage = getEveryPage(everyPage);
		currentPage = getCurrentPage(currentPage);
		int totalPage = getTotalPage(everyPage,totalCount);
		int beginIndex = getBeginIndex(everyPage,currentPage);
		boolean hasPrePage = getHasPrePage(currentPage);
		boolean hasNextPage = getHasNextPage(currentPage,totalPage);
		return new Page(everyPage,totalCount,totalPage,currentPage,beginIndex,hasPrePage,hasNextPage);
	}
	public static Page createPage(Page page,int totalCount) {
		int everyPage = getEveryPage(page.getEveryPage());
		int currentPage = getCurrentPage(page.getCurrentPage());
		int totalPage = getTotalPage(everyPage,totalCount);
		int beginIndex = getBeginIndex(everyPage,currentPage);
		boolean hasPrePage = getHasPrePage(currentPage);
		boolean hasNextPage = getHasNextPage(currentPage,totalPage);
		return new Page(everyPage,totalCount,totalPage,currentPage,beginIndex,hasPrePage,hasNextPage);
	}
	
	//����ÿҳ��ʾ��¼��
	public static int getEveryPage(int everyPage) {
		return everyPage == 0 ? 10:everyPage;
	}
	//���õ�ǰҳ
	public static int getCurrentPage(int currentPage) {
		return currentPage == 0 ? 1:currentPage;
	}
	//������ҳ��
	public static int getTotalPage(int everyPage,int totalCount) {
		return (totalCount%everyPage)==0 ? (totalCount/everyPage):(totalCount/everyPage)+1;
	}
	//������ʼ��
	public static int getBeginIndex(int everyPage,int currentPage) {
		return everyPage*(currentPage-1);
	}
	//�����Ƿ�����һҳ
	public static boolean getHasPrePage(int currentPage) {
		return currentPage == 1? false:true;
	}
	//�����Ƿ�����һҳ
	public static boolean getHasNextPage(int currentPage,int totalPage) {
		return currentPage==totalPage || totalPage==0?false:true;
	}
}
