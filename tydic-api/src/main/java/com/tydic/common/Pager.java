package com.tydic.common;

import java.io.Serializable;
import java.util.List;

public class Pager<T> implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<T> list;
	private int count;
	private int totalPage;

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	@Override
	public String toString() {
		return "Pager [list=" + list + ", count=" + count + ", totalPage=" + totalPage + "]";
	}

}
