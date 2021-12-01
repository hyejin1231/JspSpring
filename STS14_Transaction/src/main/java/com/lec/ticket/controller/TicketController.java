package com.lec.ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ticket.service.TicketService;
import com.lec.ticket.vo.TicketVO;

@Controller
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	private TicketService ticketService;
	
	@RequestMapping("/buyPage.do")
	public String buyPage() {
		return "ticket/buyPage";
	}
	
	@RequestMapping("/buyTicket.do")
	public String buyTicket(@ModelAttribute("ticket") TicketVO ticket) {
		try {
			ticketService.buyTicket(ticket);
			return "ticket/buyDone";
		}catch (Exception e) {
			e.printStackTrace();
			return "ticket/buyFail";
		}
	
	}
}
