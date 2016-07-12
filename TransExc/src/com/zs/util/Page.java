package com.zs.util;


/*2016年7月12日16:02:53
 * 张顺
 * 用于分页的分页类
 * */
public class Page {
	int pageOn;//当前页
	int pageMax;//最大页
	int size;//每页大小
	
	public Page(int pageOn,int pageMax,int size){
		this.pageOn=pageOn;
		this.pageMax=pageMax;
		this.size=size;
	}
	
	public int getPageOn() {
		return pageOn;
	}
	public void setPageOn(int pageOn) {
		this.pageOn = pageOn;
	}
	public int getPageMax() {
		return pageMax;
	}
	public void setPageMax(int pageMax) {
		this.pageMax = pageMax;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
}
