package com.lec.beans;

public class BoardDTO {
	
	private int uid;
	private String subject;
	private String content;
	private String name;
	private int viewcnt;
	private String regdate;
	

	public BoardDTO() {
		super();
		System.out.println("BoardDTO() 객체 생성");
	}


	public BoardDTO(int uid, String subject, String content, String name, int viewcnt) {
		super();
		this.uid = uid;
		this.subject = subject;
		this.content = content;
		this.name = name;
		this.viewcnt = viewcnt;
		System.out.println("BoardDTO(uid, subject, content, name, viewcnt) 객체 생성");
	}



	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
	
}
