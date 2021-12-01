package com.lec.ticket.vo;

public class TicketVO {

	private String user_id;
	private int ticket_count;
	
	public TicketVO() {
		super();
	}

	public TicketVO(String user_id, int ticket_count) {
		super();
		this.user_id = user_id;
		this.ticket_count = ticket_count;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getTicket_count() {
		return ticket_count;
	}

	public void setTicket_count(int ticket_count) {
		this.ticket_count = ticket_count;
	}
	
	
}
