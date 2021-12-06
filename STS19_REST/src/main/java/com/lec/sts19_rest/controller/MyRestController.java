package com.lec.sts19_rest.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lec.sts19_rest.dao.BoardDAO;
import com.lec.sts19_rest.service.BoardService;
import com.lec.sts19_rest.vo.BoardVO;
import com.lec.sts19_rest.vo.EmployeVO;

@RestController
@RequestMapping("/MyRest")
public class MyRestController {

	//@Autowired
	private BoardService boardService;
	
	// TEXT response
	@RequestMapping("/")
	public String helloTEXT() {
		return "HELLO REST!";
	}
	
	@RequestMapping("/helloJSON")
	public BoardVO helloJSON() {
		BoardVO board = new BoardVO(100, "REST JSON", "JSON", "HJ", 123, "2021-12-06" );
		
		return board;
	}
	
	@RequestMapping("/listJSON")
	public List<BoardVO> listJSON(){
		return boardService.list();
	}
	
	@RequestMapping("/helloXML")
	public EmployeVO helloXML() {
		return new EmployeVO(100, "홍길동", 200, new int [] {10,20,30}, 34.2);
	}
	
	@RequestMapping(value = "/read/{id}")
	public BoardVO read(@PathVariable String id) {
		BoardVO board = boardService.view(id);
		return board;
	}
	
	@RequestMapping(value = "/view/{id}")
	public ResponseEntity<BoardVO> view(@PathVariable String id) {
		BoardVO board= boardService.view(id);
		
		if(board == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<BoardVO>(board, HttpStatus.OK);
	}
 }










































