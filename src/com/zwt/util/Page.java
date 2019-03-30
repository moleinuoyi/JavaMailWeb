package com.zwt.util;

public class Page {

	//ÿҳ��ʾ��ҳ��
	private int everyPage;
	//�ܼ�¼��
	private int totalCount;
	//��ҳ��
	private int totalPage;
	//��ǰҳ
	private int currentPage;
	//��ʼ��
	private int beginIndex;
	//�Ƿ�����һҳ
	private boolean hasPrePage;
	//�Ƿ�����һҳ
	private boolean hasNextPage;
	public int getEveryPage() {
		return everyPage;
	}
	public void setEveryPage(int everyPage) {
		this.everyPage = everyPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
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
	
	public Page() {	}
	
	public Page(int everyPage,int totalCount,int totalPage,int currentPage,int beginIndex,boolean hasPrePage,boolean hasNextPage) {
		this.everyPage = everyPage;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
		this.beginIndex = beginIndex;
		this.hasPrePage = hasPrePage;
		this.hasNextPage = hasNextPage;
	}
	@Override
	public String toString() {
		return "Page [everyPage=" + everyPage + ", totalCount=" + totalCount + ", totalPage=" + totalPage
				+ ", currentPage=" + currentPage + ", beginIndex=" + beginIndex + ", hasPrePage=" + hasPrePage
				+ ", hasNextPage=" + hasNextPage + "]";
	}
}
