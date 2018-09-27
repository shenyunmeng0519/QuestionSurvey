package com.zeacen.question.bean;

import java.io.Serializable;

public class Page implements Serializable{
	private int pageon;
	private int rowcount;
	private int pagecount;
	private int row;
	private int start;
	private int end;
	private int pageNumber;
	
	public int getPageon() {
		return pageon;
	}
	public void setPageon(int pageon) {
		this.pageon = pageon;
	}
	public int getRowcount() {
		return rowcount;
	}
	public void setRowcount(int rowcount) {
		this.rowcount = rowcount;
	}
	public int getPagecount() {
		return pagecount;
	}
	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	

}
