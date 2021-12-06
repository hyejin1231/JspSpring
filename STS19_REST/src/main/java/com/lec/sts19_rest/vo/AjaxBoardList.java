package com.lec.sts19_rest.vo;

import java.util.List;

public class AjaxBoardList {

	private int count;
	private String status;
	private List<BoardVO> list;
	
	public AjaxBoardList() {
		super();
	}

	public AjaxBoardList(int count, String status, List<BoardVO> list) {
		super();
		this.count = count;
		this.status = status;
		this.list = list;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<BoardVO> getList() {
		return list;
	}

	public void setList(List<BoardVO> list) {
		this.list = list;
	}
	
	
}
