package com.lec.ticket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.ticket.dao.TicketDAO;
import com.lec.ticket.vo.TicketVO;

@Service("ticketService")
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketDAO ticketDAO;
	
	@Override
	public void buyTicket(TicketVO ticket) {
		System.out.println("buyTicket()");
		System.out.println("사용자 id : " + ticket.getUser_id());
		System.out.println("사용자 티켓 구매 개수 : "+ ticket.getTicket_count() );
		ticketDAO.buyTicket(ticket);
	}

}
