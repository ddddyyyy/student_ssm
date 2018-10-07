package com.mdy.student.bean;

import java.util.List;

/**
 * @author MDY
 * 
 * @param <T>
 */
public class Page<T> {
	private int index;//mybatis在分页时所需的下标
	private int pageNum;// 设置完页码后要设置总数据量才计算start和end
	private int pageTotal;//总页数
	public static final int pageMax = 15;//一页所显示的数据量
	private long totalData;//总数据量
	private int start;//分页栏的起始数
	private int end;//分页栏的终止数

	private List<T> list;
	
	//搜索栏所需的字段
	private String id;
	private String name;
	private char level;
	private String scoreN;
	private String sortType;
	private String sort;
	private double scoreU;// 左
	private double scoreD;// 右

	public Page() {
		this.scoreU = 0;
		this.scoreD = 100;
		this.pageNum = 1;
	}


	public double getScoreU() {
		return scoreU;
	}


	public void setScoreU(double scoreU) {
		this.scoreU = scoreU;
	}


	public double getScoreD() {
		return scoreD;
	}

	public void setScoreD(double scoreD) {
		this.scoreD = scoreD;
	}

	public void setTotalDate(long totalData) {
		int t = 1;
		if ((int) totalData % pageMax == 0) {
			t = 0;
		}
		this.pageTotal = (int) (totalData / pageMax + t);
		this.totalData = totalData;
		this.start = pageNum - 2;
		if (this.start <= 0) {
			this.start = 1;
		}
		this.end = this.start + 4;
		if (this.end >= pageTotal) {
			this.end = pageTotal;
		}
	}

	// 设置页数时计算当前数据下标
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
		this.index = (this.pageNum - 1) * pageMax;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getLevel() {
		return level;
	}

	public void setLevel(char level) {
		this.level = level;
	}

	public String getScoreN() {
		return scoreN;
	}

	public void setScoreN(String scoreN) {
		this.scoreN = scoreN;
	}

	public String getSortType() {
		return sortType;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

	public int getPageNum() {
		return pageNum;
	}

	public int getPageTotal() {
		return pageTotal;
	}

	public long getTotalDate() {
		return totalData;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public int getIndex() {
		return index;
	}
}
