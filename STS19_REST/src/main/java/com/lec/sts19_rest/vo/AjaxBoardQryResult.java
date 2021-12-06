package com.lec.sts19_rest.vo;

public class AjaxBoardQryResult {

	int count; 
	String status;
	
	public AjaxBoardQryResult() {
		super();
	}

	public AjaxBoardQryResult(int count, String status) {
		super();
		this.count = count;
		this.status = status;
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
	
	
}
