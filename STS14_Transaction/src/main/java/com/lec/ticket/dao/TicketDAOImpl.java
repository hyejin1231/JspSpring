package com.lec.ticket.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.lec.ticket.vo.TicketVO;

@Repository("ticketDAO")
public class TicketDAOImpl implements TicketDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	private TransactionTemplate transactionTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Autowired
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}
	

	@Override
	public void buyTicket(TicketVO ticket) {
		String SQL = "insert into test_ticket (user_id, ticket_count) values (?,?)";
		String SQL2 = "insert into test_card (user_id, buy_amount) values (?,?)";
		
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				jdbcTemplate.update(SQL, ticket.getUser_id(), ticket.getTicket_count());
				jdbcTemplate.update(SQL2, ticket.getUser_id(), ticket.getTicket_count());
				
			}
		});
//		jdbcTemplate.update(SQL, ticket.getUser_id(), ticket.getTicket_count());
//		jdbcTemplate.update(SQL2, ticket.getUser_id(), ticket.getTicket_count());
		
		
		
		
		System.out.println("[User id : " + ticket.getUser_id() + ", Ticket_count : " + ticket.getTicket_count());
	}

}
